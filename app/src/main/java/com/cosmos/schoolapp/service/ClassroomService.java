package com.cosmos.schoolapp.service;

import com.cosmos.schoolapp.data.RepositoryListener;
import com.cosmos.schoolapp.data.entity.ClassRoom;
import com.cosmos.schoolapp.data.entity.Level;
import com.cosmos.schoolapp.data.entity.Section;
import com.cosmos.schoolapp.data.repository.ClassroomRepository;
import com.cosmos.schoolapp.data.repository.LevelRepository;
import com.cosmos.schoolapp.data.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {

  private final ClassroomRepository classroomRepository;
  private final LevelRepository levelRepository;
  private final SectionRepository sectionRepository;

  private final List<RepositoryListener<ClassRoom>> listeners = new ArrayList<>();

  @Autowired
  public ClassroomService(
      ClassroomRepository classroom, LevelRepository level, SectionRepository section) {
    this.classroomRepository = classroom;
    this.levelRepository = level;
    this.sectionRepository = section;
  }

  public ClassRoom getClassRoomByID(String id) throws ChangeSetPersister.NotFoundException {
    // Retrieve a user from the repository //TODO handle execption
    return classroomRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
  }

  public List<ClassRoom> getAllClassroom() {
    return classroomRepository.findAll();
  }

  public List<Section> getAllSection() {
    return sectionRepository.findAll();
  }

  public Section getSectionByID(String id) throws ChangeSetPersister.NotFoundException {
    // Retrieve a user from the repository //TODO handle
    return sectionRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
  }

  public void saveSection(Section section) {
    sectionRepository.save(section);
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
