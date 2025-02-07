package com.ydova.schoolapp.client.views;

import com.ydova.schoolapp.client.components.SectionDialog;
import com.ydova.schoolapp.server.entity.Classroom;
import com.ydova.schoolapp.server.entity.Level;
import com.ydova.schoolapp.server.entity.Section;

import com.ydova.schoolapp.server.service.SchoolService;
import com.ydova.schoolapp.server.service.ServiceFactory;
import com.ydova.schoolapp.client.utils.AlertBuilder;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SchoolController
        implements Controller,
        Initializable {


    public TableView<Section> sectionTable;
    public TableColumn<Section, String> sectionCol;


    public TableView<Classroom> classTable;
    public TableColumn<Classroom, String> classroomCol;

    public TableView<Level> levelTable;
    public TableColumn<Level, String> levelCol;





    private final SchoolService schoolService;


    public SplitPane sectionSplitPane;

    private final ObservableList<Section> sectionList = FXCollections.observableArrayList();
    private final ObservableList<Level> levelList = FXCollections.observableArrayList();
    private final ObservableList<Classroom> classroomList = FXCollections.observableArrayList();
    public TableColumn sectionNameCol;

    public SchoolController() {
        schoolService = ServiceFactory.getInstance(SchoolService.class);
    }




  public void   initLevelTab(){

    levelList.addAll(schoolService.readAllLevels());

    levelTable.setItems(levelList);
    levelCol.setCellValueFactory(
            cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getName())));

  }


  public void   initClassroomTab(){

    classroomList.addAll(schoolService.readAllClassrooms());
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



    private boolean isNotFill(TextField className, String name) {
        if (className.textProperty().isEmpty().get()) {
            AlertBuilder.error("Remplir le champ " + name);
            return true;
        }
        return false;
    }










   public void selectSection(MouseEvent mouseEvent) {
     Section  currentSection = sectionTable.getSelectionModel().getSelectedItem();

       SectionDialog.createDialog(currentSection,schoolService,"Edit section");

       sectionList.clear();
       sectionList.addAll(schoolService.readAllSections());
   }

    public void addSection(ActionEvent actionEvent) {
      Section  currentSection =  new Section();

        SectionDialog.createDialog(currentSection,schoolService,"Create Section");

        sectionList.clear();
        sectionList.addAll(schoolService.readAllSections());
    }

    public void addClassroom(ActionEvent actionEvent) {
    }

    public void addCours(ActionEvent actionEvent) {
    }

    public void addLevel(ActionEvent actionEvent) {

    }
}
