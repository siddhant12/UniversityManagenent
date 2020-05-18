package com.universitymanagement.service;

import com.universitymanagement.dto.StudentDTO;
import com.universitymanagement.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentDTO studentDTO);
    List<Student> getAllStudents();
}
