package com.cosmos.schoolapp.service;

import com.cosmos.schoolapp.data.entity.ClassRoom;
import com.cosmos.schoolapp.data.entity.Level;
import com.cosmos.schoolapp.data.entity.Section;
import com.cosmos.schoolapp.data.observer.ClassroomDataObserver;
import com.cosmos.schoolapp.data.observer.LevelDataObserver;
import com.cosmos.schoolapp.data.observer.SectionDataObserver;
import com.cosmos.schoolapp.data.observer.StudentDataObserver;
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

  private List<ClassroomDataObserver> classroomDataObservers = new ArrayList<>();
  private List<SectionDataObserver> sectionDataObservers = new ArrayList<>();
  private List<LevelDataObserver> levelDataObservers = new ArrayList<>();

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
    notify(section);
  }

  public void saveClassRoom(ClassRoom classRoom) {
    classroomRepository.save(classRoom);
    notify(classRoom);
  }

  private void notify(ClassRoom classRoom) {
    classroomDataObservers.forEach(o -> o.onClassroomUpdated(classRoom));
  }

  private void notify(Section section) {
    sectionDataObservers.forEach(o -> o.onSectionUpdated(section));
  }

  private void notify(Level level) {
    levelDataObservers.forEach(o -> o.onLevelUpdated(level));
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
    notify(level);
  }

  public void addObserver(SectionDataObserver observer) {
    this.sectionDataObservers.add(observer);
  }

  public void addObserver(LevelDataObserver observer) {
    this.levelDataObservers.add(observer);
  }

  public void addObserver(ClassroomDataObserver observer) {
    this.classroomDataObservers.add(observer);
  }
}
