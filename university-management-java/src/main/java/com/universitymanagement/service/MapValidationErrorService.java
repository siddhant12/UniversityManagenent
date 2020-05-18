package com.universitymanagement.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {
    public ResponseEntity<?> mapValidationService(BindingResult result){
        if(result.hasErrors()){
            Map<String,String> map = new HashMap<>();
            for(FieldError error: result.getFieldErrors()){
                map.put(error.getField(),error.getDefaultMessage());
            }
            return  new ResponseEntity<Map<String,String>>(map , HttpStatus.BAD_REQUEST);
            //return  new ResponseEntity<String>("Invalid Project Object" , HttpStatus.BAD_REQUEST);
            //return  new ResponseEntity<List<FieldError>>(result.getFieldErrors() , HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
