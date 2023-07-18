package com.cosmos.schoolapp.service;

import com.cosmos.schoolapp.RepositoryListener;
import com.cosmos.schoolapp.entity.ClassRoom;
import com.cosmos.schoolapp.entity.Level;
import com.cosmos.schoolapp.repository.ClassroomRepository;
import com.cosmos.schoolapp.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {

  private final ClassroomRepository classroomRepository;
  private final LevelRepository levelRepository;

  private final List<RepositoryListener<ClassRoom>> listeners = new ArrayList<>();

  @Autowired
  public ClassroomService(ClassroomRepository classroom, LevelRepository level) {
    this.classroomRepository = classroom;
    this.levelRepository = level;
  }

  public ClassRoom getClassRoomByID(String id) throws ChangeSetPersister.NotFoundException {
    // Retrieve a user from the repository //TODO handle
    return classroomRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
  }

  public List<ClassRoom> getAllClassroom() {
    return classroomRepository.findAll();
  }

  public void saveClassRoom(ClassRoom classRoom) {
    classroomRepository.save(classRoom);
    for (RepositoryListener<ClassRoom> listener : listeners) {
      listener.onUserChange(classRoom);
    }
  }

  public Level getLevelByID(String id) throws ChangeSetPersister.NotFoundException {
    // Retrieve a user from the repository //TODO handle
    return levelRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
  }

  public List<Level> getAllLevel() {
    return levelRepository.findAll();
  }

  public void saveLevel(Level level) {
    levelRepository.save(level);
  }

  public void addStudentChangeListener(RepositoryListener<ClassRoom> listener) {
    listeners.add(listener);
  }
}
