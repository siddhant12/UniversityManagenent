package com.universitymanagement.controller;

import com.universitymanagement.dto.StudentDTO;
import com.universitymanagement.entity.Student;
import com.universitymanagement.service.MapValidationErrorService;
import com.universitymanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> createStudent(@Valid @RequestBody StudentDTO studentDTO, BindingResult result) {
        ResponseEntity<?> mapErrors = mapValidationErrorService.mapValidationService(result);
        if (mapErrors != null)
            return mapErrors;
        Student newStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
}
