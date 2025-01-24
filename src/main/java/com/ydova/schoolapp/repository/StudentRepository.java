package com.ydova.schoolapp.repository;

import com.ydova.schoolapp.entity.Student;

public class StudentRepository  extends YRepository<Student,Long>{
    public StudentRepository() {
        super(Student.class);
    }
}
