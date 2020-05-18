package com.universitymanagement.controller;

import com.universitymanagement.entity.University;
import com.universitymanagement.service.MapValidationErrorService;
import com.universitymanagement.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UniversityService universityService;

    @PostMapping("/create")
    public ResponseEntity<?> createUniversity(@Valid @RequestBody University university, BindingResult result){
        ResponseEntity<?> mapErrors = mapValidationErrorService.mapValidationService(result);
        if(mapErrors != null)
            return mapErrors;
        University newUniversity = universityService.createUniversity(university);
        return new ResponseEntity<>(newUniversity, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<University>> findAllUniversities(){
        List<University> universityList = universityService.findAllUniversities();
        return new ResponseEntity<>(universityList,HttpStatus.OK);
    }

    @GetMapping("/ucs")
    public ResponseEntity<University> findUniversityById(){
        University university =  universityService.getUniversity();
        return ResponseEntity.ok(university);
    }

}
