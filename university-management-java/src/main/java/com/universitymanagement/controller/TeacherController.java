package com.universitymanagement.controller;

import com.universitymanagement.dto.TeacherDTO;
import com.universitymanagement.entity.Teacher;
import com.universitymanagement.service.MapValidationErrorService;
import com.universitymanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @PostMapping("/create")
    public ResponseEntity<?> createSubject(@Valid @RequestBody TeacherDTO teacherDTO , BindingResult result) {
        ResponseEntity<?> mapError = mapValidationErrorService.mapValidationService(result);
        if (mapError != null)
            return mapError;

        Teacher newTeacher = teacherService.createTeacher(teacherDTO);
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }

   @GetMapping("/getAllTeacher")
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        List<Teacher> getAllTeacher = teacherService.getAllTeachers();
        return new ResponseEntity<>(getAllTeacher,HttpStatus.OK);
   }
}
