package com.universitymanagement.controller;

import com.universitymanagement.entity.User;
import com.universitymanagement.payload.JWTSuccessLoginResponse;
import com.universitymanagement.payload.LoginRequest;
import com.universitymanagement.security.JwtTokenProvider;
import com.universitymanagement.service.MapValidationErrorService;
import com.universitymanagement.service.UserService;
import com.universitymanagement.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.universitymanagement.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

   @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user,BindingResult result){
       userValidator.validate(user,result);
       ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
       if(errorMap != null) return errorMap;


       User registerUser = userService.saveUser(user);
       return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
   }

   @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest loginRequest,
                            BindingResult result){
       ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationService(result);
       if(errorMap!=null) return errorMap;
       //authenticating user using authenticate()
       Authentication authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));
       SecurityContextHolder.getContext().setAuthentication(authentication);

       //generating jwt token
       String jwt = TOKEN_PREFIX + jwtTokenProvider.generateToken(authentication);
       return ResponseEntity.ok(new JWTSuccessLoginResponse(true,jwt));
   }

   @GetMapping("/id/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
       User user = userService.findUserByUsername(username);
       return new ResponseEntity<>(user,HttpStatus.OK);
   }

}
