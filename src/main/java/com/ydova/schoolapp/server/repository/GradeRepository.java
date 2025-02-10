package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.Grade;

public class GradeRepository extends  YRepository<Grade,Long>{
    public GradeRepository() {
        super(Grade.class);
    }
}
