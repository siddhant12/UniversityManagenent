package com.universitymanagement.repository;

import com.universitymanagement.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    Optional<Subject> findBySubjectName(String subjectName);

}
