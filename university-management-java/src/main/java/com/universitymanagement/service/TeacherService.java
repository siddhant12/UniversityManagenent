package com.universitymanagement.service;

import com.universitymanagement.dto.TeacherDTO;
import com.universitymanagement.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher createTeacher(TeacherDTO teacherDTO);
    List<Teacher> getAllTeachers();
}
