package com.cosmos.schoolapp.repository;

import com.cosmos.schoolapp.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassRoom, String> {
  List<ClassRoom> findByLevelID(long levelID);

  List<ClassRoom> findByName(String name);
}
