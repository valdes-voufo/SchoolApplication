package com.cosmos.schoolapp.service.classrooms;

import com.cosmos.schoolapp.entity.ClassRoom;
import com.cosmos.schoolapp.entity.Level;
import com.cosmos.schoolapp.entity.Section;
import com.cosmos.schoolapp.observer.ClassroomDataObserver;
import com.cosmos.schoolapp.observer.LevelDataObserver;
import com.cosmos.schoolapp.observer.SectionDataObserver;
import com.cosmos.schoolapp.repository.ClassroomRepository;
import com.cosmos.schoolapp.repository.LevelRepository;
import com.cosmos.schoolapp.repository.SectionRepository;
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

  private final List<ClassroomDataObserver> classroomDataObservers = new ArrayList<>();
  private final List<SectionDataObserver> sectionDataObservers = new ArrayList<>();
  private final List<LevelDataObserver> levelDataObservers = new ArrayList<>();

  @Autowired
  public ClassroomService(
      ClassroomRepository classroom, LevelRepository level, SectionRepository section) {
    this.classroomRepository = classroom;
    this.levelRepository = level;
    this.sectionRepository = section;
  }

  public ClassRoom getClassRoomByID(String id) throws ChangeSetPersister.NotFoundException {
    return classroomRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
  }

  public List<ClassRoom> getAllClassroom() {
    return classroomRepository.findAll();
  }

  public List<Section> getAllSection() {
    return sectionRepository.findAll();
  }

  public Section getSectionByID(String id) throws ChangeSetPersister.NotFoundException {
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
