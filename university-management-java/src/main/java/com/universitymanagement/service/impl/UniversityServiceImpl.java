package com.universitymanagement.service.impl;


import com.universitymanagement.entity.University;
import com.universitymanagement.repository.UniversityRepository;
import com.universitymanagement.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public List<University> findAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University getUniversity() {
        Optional<University> getUniversity = universityRepository.findById(1L);
        if(getUniversity.isPresent())
            return getUniversity.get();
        else
            return null;
    }

}
