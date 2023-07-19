package com.cosmos.schoolapp.controller.task;

import com.cosmos.schoolapp.controller.MyController;

import com.cosmos.schoolapp.data.entity.ClassRoom;
import com.cosmos.schoolapp.data.entity.Level;
import com.cosmos.schoolapp.data.entity.Section;
import com.cosmos.schoolapp.service.ClassroomService;
import com.cosmos.schoolapp.util.AlertBuilder;
import com.cosmos.schoolapp.util.Loader;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
public class ClassroomController implements MyController, Initializable {

  public TextField className;
  public ComboBox<Level> classLevel;

  public TextField levelName;
  public TextField levelSchoolFee;
  public ComboBox<Section> levelSection;

  public TextField sectionName;
  public TableView<Section> sectionTable;
  public TableColumn<Section,String> sectionSectionCol;
  public TableColumn<Section,Double> sectionStudentCol;
  public TableColumn<Section,Double> sectionWomenCol;
  public TableColumn<Section,Double> sectionMenCol;
  public TableView<Level> levelTable1;
  public TableColumn<Level,String> levelLevelCol;
  public TableColumn<Level,Double> levelStudentCol;
  public TableColumn<Level,Double> levelWomenCol;
  public TableColumn<Level,Double> levelMenCol;
  public TableView<ClassRoom> classTable;
  public TableColumn<ClassRoom,String> classClassCol;
  public TableColumn<ClassRoom,Double> classStudentCol;
  public TableColumn<ClassRoom,Double> classWomenCol;
  public TableColumn<ClassRoom,Double> classMenCol;
  protected ConfigurableApplicationContext ctx;

  protected ClassroomService classroomService;

  protected AnchorPane pane;

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
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    levelSection.setItems(FXCollections.observableList(classroomService.getAllSection()));
    classLevel.setItems(FXCollections.observableList(classroomService.getAllLevel()));

    sectionTable.setItems(FXCollections.observableList(classroomService.getAllSection()));
    sectionSectionCol.setCellValueFactory(
            cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getName())));

    levelTable1.setItems(FXCollections.observableList(classroomService.getAllLevel()));
    levelLevelCol.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));

    classTable.setItems(FXCollections.observableList(classroomService.getAllClassroom()));
    classClassCol.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));

  }

  public void addClassroom(ActionEvent actionEvent) {
    if (!checkFill(className, "classe")) {
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

  private boolean checkFill(TextField className, String name) {
    if (className.textProperty().isEmpty().get()) {
      AlertBuilder.error("Remplir le champ " + name);
      return false;
    }
    return true;
  }

  public void addLevel(ActionEvent actionEvent) {
    if (!checkFill(levelName, "Level")) {
      return;
    }

    if (!checkFill(levelSchoolFee, "PENSION")) {
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
    if (!checkFill(sectionName, "Section")) {
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


}
