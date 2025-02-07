package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.Classroom;

public class ClassroomRepository extends YRepository<Classroom,Long>{
    public ClassroomRepository() {
        super(Classroom.class);
    }
}
