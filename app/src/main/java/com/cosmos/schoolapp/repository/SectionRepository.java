package com.cosmos.schoolapp.repository;

import com.cosmos.schoolapp.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectionRepository extends JpaRepository<Section, String> {}
