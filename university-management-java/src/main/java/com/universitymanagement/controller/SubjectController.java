package com.universitymanagement.controller;

import com.universitymanagement.entity.Subject;
import com.universitymanagement.service.MapValidationErrorService;
import com.universitymanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/create")
    public ResponseEntity<?> createSubject(@Valid @RequestBody Subject subject , BindingResult result){
        ResponseEntity<?> mapError = mapValidationErrorService.mapValidationService(result);
        if(mapError != null)
            return mapError;
        Subject newSubject = subjectService.createSubject(subject);
        return new ResponseEntity<>(newSubject, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subject>> getAllSubject(){
        List<Subject> subjectList = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjectList,HttpStatus.OK);
    }
 }
