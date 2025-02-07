package com.ydova.schoolapp.server.repository;

import com.ydova.schoolapp.server.entity.Section;

public class SectionRepository extends  YRepository<Section,Long> {
    public SectionRepository() {
        super(Section.class);
    }
}
