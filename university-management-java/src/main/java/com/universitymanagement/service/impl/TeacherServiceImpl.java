package com.universitymanagement.service.impl;

import com.universitymanagement.dto.TeacherDTO;
import com.universitymanagement.entity.Subject;
import com.universitymanagement.entity.Teacher;
import com.universitymanagement.repository.TeacherRepository;
import com.universitymanagement.service.SubjectService;
import com.universitymanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectService subjectService;

    @Override
    public Teacher createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        Subject subject = subjectService.getSubjectBySubjectName(teacherDTO.getSubjectName());
        teacher.setTeacherId(teacherDTO.getTeacherId());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName((teacherDTO.getLastName()));
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setDob(teacherDTO.getDob());
        teacher.setSubject(subject);
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
