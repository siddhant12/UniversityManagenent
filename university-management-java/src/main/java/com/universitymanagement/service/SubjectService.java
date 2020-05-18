package com.universitymanagement.service;

import com.universitymanagement.entity.Subject;

import java.util.List;

public interface SubjectService {
    public Subject createSubject(Subject subject);
    public List<Subject> getAllSubjects();
    public Subject getSubjectBySubjectName(String subjectName);
}
