package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.Course;

public class CouresRepository extends  YRepository<Course,Long> {
    public CouresRepository() {
        super(Course.class);
    }
}
