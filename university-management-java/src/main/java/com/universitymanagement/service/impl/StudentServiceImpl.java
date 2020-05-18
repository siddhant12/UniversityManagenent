package com.universitymanagement.service.impl;

import com.universitymanagement.dto.StudentDTO;
import com.universitymanagement.entity.Student;
import com.universitymanagement.entity.Subject;
import com.universitymanagement.repository.StudentRepository;
import com.universitymanagement.service.StudentService;
import com.universitymanagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectService subjectService;

    @Override
    @Transactional
    public Student createStudent(StudentDTO studentDTO) {
        List<Subject> subjectList = new ArrayList<>();
        Student student = new Student();
        student.setStudentId(studentDTO.getStudentId());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setDob(studentDTO.getDob());

        studentDTO.getSubjectList().stream().forEach( subject -> {
            Subject getSubject = subjectService.getSubjectBySubjectName(subject);
            subjectList.add(getSubject);
        });
        student.setSubjectList(subjectList);
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
