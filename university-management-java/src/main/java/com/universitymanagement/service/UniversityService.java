package com.universitymanagement.service;

import com.universitymanagement.entity.University;

import java.util.List;

public interface UniversityService {

    University createUniversity(University university);
    List<University> findAllUniversities();
    University getUniversity();
}
