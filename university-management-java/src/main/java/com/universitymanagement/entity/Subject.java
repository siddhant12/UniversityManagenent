package com.universitymanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank
    private String subjectCode;
    @Column(unique = true)
    @NotBlank
    private String subjectName;
    @ManyToMany(fetch = FetchType.LAZY , cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    @JoinTable(name = "student_subject" , joinColumns = @JoinColumn(name = "subject_id"),inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnore
    private List<Student> studentList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "subject" , cascade = {CascadeType.DETACH , CascadeType.MERGE , CascadeType.PERSIST , CascadeType.REFRESH })
    @JsonIgnore
    private List<Teacher> teacherList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "university_id")
    @JsonIgnore
    private University university;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }
}
