package com.cosmos.schoolapp.data.repository;

import com.cosmos.schoolapp.data.entity.Level;
import com.cosmos.schoolapp.data.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, String> {}
