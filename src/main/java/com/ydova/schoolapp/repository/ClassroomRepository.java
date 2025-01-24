package com.ydova.schoolapp.repository;

import com.ydova.schoolapp.entity.Classroom;
import com.ydova.schoolapp.entity.Student;

public class ClassroomRepository extends YRepository<Classroom,Long>{
    public ClassroomRepository() {
        super(Classroom.class);
    }
}
