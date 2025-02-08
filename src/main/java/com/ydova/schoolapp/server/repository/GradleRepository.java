package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.Gradle;

public class GradleRepository extends  YRepository<Gradle,Long>{
    public GradleRepository() {
        super(Gradle.class);
    }
}
