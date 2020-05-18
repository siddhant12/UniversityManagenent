package com.universitymanagement.service.impl;

import com.universitymanagement.entity.Subject;
import com.universitymanagement.entity.University;
import com.universitymanagement.repository.SubjectRepository;
import com.universitymanagement.service.SubjectService;
import com.universitymanagement.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private UniversityService universityService;

    @Override
    public Subject createSubject(Subject subject) {
        University university = universityService.getUniversity();
        subject.setUniversity(university);
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubjectBySubjectName(String subjectName) {
        Optional<Subject> subject = subjectRepository.findBySubjectName(subjectName);
        if(subject.isPresent())
            return subject.get();
        else
            return null;
    }

}
