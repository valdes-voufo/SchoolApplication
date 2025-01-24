package com.ydova.schoolapp.controller;

import com.ydova.schoolapp.entity.Classroom;
import com.ydova.schoolapp.entity.Level;
import com.ydova.schoolapp.entity.Section;

import com.ydova.schoolapp.service.SchoolService;
import com.ydova.schoolapp.service.ServiceFactory;
import com.ydova.schoolapp.utils.AlertBuilder;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SchoolController
        implements Controller,
        Initializable {


    private final ObservableList<Section> sectionList = FXCollections.observableArrayList();
    private final ObservableList<Level> levelList = FXCollections.observableArrayList();
    private final ObservableList<Classroom> classroomList = FXCollections.observableArrayList();

    public TextField className;


    public ComboBox<Level> classLevel;






  public TextField levelName;
  public TableView<Level> levelTable;
  public TextField levelSchoolFee;
  public ComboBox<Section> levelSection;
  public TableColumn<Level, String> levelCol;



    public TableView<Section> sectionTable;
    public TableColumn<Section, String> sectionCol;


    public TableView<Classroom> classTable;
    public TableColumn<Classroom, String> classroomCol;
    public TextField sectionName;

    public TextField secRightName;


    private final SchoolService schoolService;


    public SplitPane sectionSplitPane;


  public SchoolController() {
        schoolService = ServiceFactory.getInstance(SchoolService.class);
    }


    public void addSection(ActionEvent actionEvent) {
        if (isNotFill(sectionName, "Section")) {
            return;
        }
        // build and save section
        Section section = new Section();
        section.setName(sectionName.getText());
        schoolService.saveSection(section);

        // clear fields
        sectionName.clear();


        sectionList.clear();
        sectionList.addAll(schoolService.readAllSections());

        // show confirmation
        // AlertBuilder.info("Section " + section.getName() + " Ajouter avec Success");
    }


  public void   initLevelTab(){

    levelList.addAll(schoolService.readAllLevels());
    levelSection.setItems(sectionList);
    levelTable.setItems(levelList);
    levelCol.setCellValueFactory(
            cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getName())));

  }


  public void   initClassroomTab(){

    classroomList.addAll(schoolService.readAllClassrooms());
    classLevel.setItems(levelList);
    classTable.setItems(classroomList);
    classroomCol.setCellValueFactory(
            cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getName())));

  }

  public void   initSectionTab(){

    sectionList.addAll(schoolService.readAllSections());
    sectionTable.setItems(sectionList);
    sectionCol.setCellValueFactory(
            cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getName())));

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       initSectionTab();

       initLevelTab();

       initClassroomTab();
    }

    public void addClassroom(ActionEvent actionEvent) {
        if (isNotFill(className, "classe")) {
            return;
        }

        if (classLevel.getSelectionModel().isEmpty()) {
            return;
        }

        // build and save school
        Classroom classRoom = new Classroom();
        classRoom.setLevelID(classLevel.getValue().getLevelID());
        classRoom.setName(className.getText());
        schoolService.saveClassroom(classRoom);

        // clear fields
        className.clear();
        classLevel.getSelectionModel().clearSelection();

        // show confirmation
        // AlertBuilder.info("Classe " + classRoom.getName() + " Ajouter avec Success");
      classroomList.clear();
      classroomList.addAll(schoolService.readAllClassrooms());
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
         schoolService.saveLevel(level);

        // clear fields
        levelSection.getSelectionModel().clearSelection();
        levelName.clear();
        levelSchoolFee.clear();

        levelList.clear();
        levelList.addAll(schoolService.readAllLevels());

        // show confirmation
        //  AlertBuilder.info("Niveau " + level.getName() + " Ajouter avec Success");
    }


    public void selectSection(MouseEvent mouseEvent) {
        if (!sectionTable.getSelectionModel().isEmpty()) {
            secRightName.setText(sectionTable.getSelectionModel().getSelectedItem().getName());
        }
    }

    public void deleteSection(ActionEvent actionEvent) {

    }
}
