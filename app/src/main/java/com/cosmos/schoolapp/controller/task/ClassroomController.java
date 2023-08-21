package com.cosmos.schoolapp.controller.task;

import com.cosmos.schoolapp.controller.MyController;

import com.cosmos.schoolapp.data.entity.ClassRoom;
import com.cosmos.schoolapp.data.entity.Level;
import com.cosmos.schoolapp.data.entity.Section;
import com.cosmos.schoolapp.data.observer.ClassroomDataObserver;
import com.cosmos.schoolapp.data.observer.LevelDataObserver;
import com.cosmos.schoolapp.data.observer.SectionDataObserver;
import com.cosmos.schoolapp.service.ClassroomService;
import com.cosmos.schoolapp.util.AlertBuilder;
import com.cosmos.schoolapp.util.Loader;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class ClassroomController
    implements MyController,
        Initializable,
        ClassroomDataObserver,
        SectionDataObserver,
        LevelDataObserver {

  public TextField className;
  public ComboBox<Level> classLevel;

  public TextField levelName;
  public TextField levelSchoolFee;
  public ComboBox<Section> levelSection;

  public TextField sectionName;
  public TableView<Section> sectionTable;
  public TableColumn<Section, String> sectionSectionCol;
  public TableColumn<Section, Double> sectionStudentCol;
  public TableColumn<Section, Double> sectionWomenCol;
  public TableColumn<Section, Double> sectionMenCol;
  public TableView<Level> levelTable1;
  public TableColumn<Level, String> levelLevelCol;
  public TableColumn<Level, Double> levelStudentCol;
  public TableColumn<Level, Double> levelWomenCol;
  public TableColumn<Level, Double> levelMenCol;
  public TableView<ClassRoom> classTable;
  public TableColumn<ClassRoom, String> classClassCol;
  public TableColumn<ClassRoom, Double> classStudentCol;
  public TableColumn<ClassRoom, Double> classWomenCol;
  public TableColumn<ClassRoom, Double> classMenCol;
  public TextField secRightName;
  protected ConfigurableApplicationContext ctx;

  protected ClassroomService classroomService;

  protected AnchorPane pane;

  private ObservableList<Section> sectionList = FXCollections.observableArrayList();
  private ObservableList<Level> levelList = FXCollections.observableArrayList();
  private ObservableList<ClassRoom> classroomList = FXCollections.observableArrayList();

  @Autowired
  public ClassroomController(ClassroomService service, ConfigurableApplicationContext ctx) {
    this.classroomService = service;
    this.ctx = ctx;
  }

  @Override
  public Pane getPane() {
    return pane;
  }

  @Value("classpath:/schoolapp/layout/main/main-right/classroom/classroom.fxml")
  Resource resource;

  @Override
  public Pane buildPaneRecursive() {
    pane = Loader.load(resource, ctx);
    return pane;
  }

 public void initSectionTable(){

 }
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    classroomService.addObserver((ClassroomDataObserver) this);
    classroomService.addObserver((SectionDataObserver) this);
    classroomService.addObserver((LevelDataObserver) this);

    classroomList = FXCollections.observableArrayList(classroomService.getAllClassroom());
    sectionList = FXCollections.observableArrayList(classroomService.getAllSection());
    levelList = FXCollections.observableArrayList(classroomService.getAllLevel());

    levelSection.setItems(sectionList);
    classLevel.setItems(levelList);

    sectionTable.setItems(sectionList);
    sectionSectionCol.setCellValueFactory(
        cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getName())));

    levelTable1.setItems(levelList);
    levelLevelCol.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getName()));

    classTable.setItems(classroomList);
    classClassCol.setCellValueFactory(
        cellData -> new SimpleStringProperty(cellData.getValue().getName()));
  }

  public void addClassroom(ActionEvent actionEvent) {
    if (isNotFill(className, "classe")) {
      return;
    }

    if (classLevel.getSelectionModel().isEmpty()) {
      return;
    }

    // build and save classroom
    ClassRoom classRoom = new ClassRoom();
    classRoom.setLevelID(classLevel.getValue().getLevelID());
    classRoom.setName(className.getText());
    classroomService.saveClassRoom(classRoom);

    // clear fields
    className.clear();
    classLevel.getSelectionModel().clearSelection();

    // show confirmation
    AlertBuilder.info("Classe " + classRoom.getName() + " Ajouter avec Success");
  }

  private boolean isNotFill(TextField className, String name) {
    if (className.textProperty().isEmpty().get()) {
      AlertBuilder.error("Remplir le champ " + name);
      return true;
    }
    return false;
  }

  public void addLevel(ActionEvent actionEvent) {
    if (isNotFill(levelName, "Level")) {
      return;
    }

    if (isNotFill(levelSchoolFee, "PENSION")) {
      return;
    }
    if (levelSection.getSelectionModel().isEmpty()) {
      return;
    }

    // build and save level
    Level level = new Level();
    level.setSectionID(levelSection.getValue().getSectionID());
    level.setName(levelName.getText());
    level.setSchoolFees(Double.parseDouble(levelSchoolFee.getText()));
    classroomService.saveLevel(level);

    // clear fields
    levelSection.getSelectionModel().clearSelection();
    levelName.clear();
    levelSchoolFee.clear();

    // show confirmation
    AlertBuilder.info("Niveau " + level.getName() + " Ajouter avec Success");
  }

  public void addSection(ActionEvent actionEvent) {
    if (isNotFill(sectionName, "Section")) {
      return;
    }
    // build and save section
    Section section = new Section();
    section.setName(sectionName.getText());
    classroomService.saveSection(section);

    // clear fields
    sectionName.clear();

    // show confirmation
    AlertBuilder.info("Section " + section.getName() + " Ajouter avec Success");
  }

  @Override
  public void onClassroomUpdated(ClassRoom classRoom) {
    classroomList.clear();
    classroomList.addAll(classroomService.getAllClassroom());
  }

  @Override
  public void onSectionUpdated(Section section) {
    sectionList.clear();
    sectionList.addAll(classroomService.getAllSection());
  }

  @Override
  public void onLevelUpdated(Level level) {
    levelList.clear();
    levelList.addAll(classroomService.getAllLevel());
  }

  public void selectSection(MouseEvent mouseEvent) {
    if (!sectionTable.getSelectionModel().isEmpty()){
      secRightName.setText(sectionTable.getSelectionModel().getSelectedItem().getName());
    }
  }

  public void deleteSection(ActionEvent actionEvent) {
  }
}
