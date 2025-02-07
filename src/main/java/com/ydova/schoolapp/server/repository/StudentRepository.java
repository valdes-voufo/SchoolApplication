package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.Student;

public class StudentRepository  extends YRepository<Student,Long>{
    public StudentRepository() {
        super(Student.class);
    }
}
