package com.ydova.schoolapp.repository;

import com.ydova.schoolapp.entity.Section;

public class SectionRepository extends  YRepository<Section,Long> {
    public SectionRepository() {
        super(Section.class);
    }
}
