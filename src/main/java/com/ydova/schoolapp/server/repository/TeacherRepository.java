package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.Teacher;

public class TeacherRepository extends  YRepository<Teacher,Long>{
    public TeacherRepository() {
        super(Teacher.class);
    }

}
