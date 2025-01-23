package com.ydova.schoolapp.controller;



import com.ydova.schoolapp.Gender;
import com.ydova.schoolapp.entity.ClassRoom;
import com.ydova.schoolapp.entity.Level;
import com.ydova.schoolapp.entity.Section;
import com.ydova.schoolapp.entity.Student;
import com.ydova.schoolapp.observer.ClassroomDataObserver;
import com.ydova.schoolapp.observer.LevelDataObserver;
import com.ydova.schoolapp.observer.SectionDataObserver;
import com.ydova.schoolapp.service.ClassroomService;


import com.ydova.schoolapp.service.StudentService;
import com.ydova.schoolapp.draft.AlertBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.net.URL;
import java.time.Year;
import java.util.Optional;
import java.util.ResourceBundle;

// @Controller

public class InscriptionController
    implements Initializable,
        Controller,
        ClassroomDataObserver,
        SectionDataObserver,
        LevelDataObserver {
  public TextField lastname;
  public TextField firstname;
  public CheckBox maleCheckBox;

  public CheckBox femaleCheckBox;
  public TextField address;

  public DatePicker dateOfBirth;
  public TextField birthPlace;
  public ImageView profilPicture;
  public ChoiceBox<Year> academicYear;
  public ChoiceBox<ClassRoom> classRoom;
  public ChoiceBox<Level> level;
  public ChoiceBox<Section> section;

String file = "classpath:/schoolapp/layout/main/main-right/inscription/inscription.fxml";


  protected StudentService studentService;



  protected Pane pane;

  private ObservableList<Section> sectionList = FXCollections.observableArrayList();
  private ObservableList<Level> levelList = FXCollections.observableArrayList();
  private ObservableList<ClassRoom> classroomList = FXCollections.observableArrayList();
  ClassroomService classroomService;

  public InscriptionController() {


    this.classroomService = classroomService;
  }

  @Override
  public Pane getPane() {
    return pane;
  }

  @Override
  public Pane buildPaneRecursive() {
    pane = ControllerUtils.loadPane(file);
    return pane;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  //  classroomService.addObserver((ClassroomDataObserver) this);
  //  classroomService.addObserver((SectionDataObserver) this);
  //  classroomService.addObserver((LevelDataObserver) this);
 //   classroomList = FXCollections.observableArrayList(classroomService.getAllClassroom());
 //   sectionList = FXCollections.observableArrayList(classroomService.getAllSection());
 //   levelList = FXCollections.observableArrayList(classroomService.getAllLevel());
    section.setItems(sectionList);
    level.setItems(levelList);
    classRoom.setItems(classroomList);
  }

  public void performInscription(ActionEvent actionEvent) {

    // check fields that mandatory field are filled
    if (!checkFields()) {
      return;
    }

    // build the new student
    Student student =
        Student.builder()
            .lastname(lastname.getText())
            .firstname(firstname.getText())
            .gender(getGender())
            .adresse(address.getText())
            .birthDate(dateOfBirth.getValue())
            .birthPlace(birthPlace.getText())
            .build();

    if (confirmInscription()) {
      studentService.saveStudent(student);
      inscriptionSucceed();
    }
  }

  public void inscriptionSucceed() {
    AlertBuilder.info("eleve inscrit avec Success");
  }

  protected boolean confirmInscription() {
    Alert alert =
        AlertBuilder.alert("Confirmation", "Confirmer L'inscription", Alert.AlertType.CONFIRMATION);
    Optional<ButtonType> result = alert.showAndWait();
    return result.isPresent() && result.get().getButtonData().isDefaultButton();
  }

  private Gender getGender() {
    if (maleCheckBox.isSelected()) {
      return Gender.MALE;
    }
    return Gender.FEMALE;
  }

  protected boolean checkFields() {
    if (lastname.textProperty().isEmpty().get()) {
      AlertBuilder.error("Prenom non remplis");
      return false;
    }
    if (firstname.textProperty().isEmpty().get()) {
      AlertBuilder.error("Prenom non remplis");
      return false;
    }
    if (!maleCheckBox.isSelected() && !femaleCheckBox.isSelected()) {
      AlertBuilder.error("Sexe non remplis");
      return false;
    }
    if (address.textProperty().isEmpty().get()) {
      AlertBuilder.error("Adresse non remplis");
      return false;
    }
    if (birthPlace.textProperty().isEmpty().get()) {
      AlertBuilder.error("Lieu de Naissance non remplis");
      return false;
    }
    return true;
  }

  public void pictureImport(ActionEvent actionEvent) {}

  public void payedAmount(ActionEvent actionEvent) {}

  @FXML
  public void CheckMale(ActionEvent actionEvent) {
    femaleCheckBox.setSelected(false);
    maleCheckBox.setSelected(true);
  }

  @FXML
  public void checkFemale(ActionEvent actionEvent) {
    maleCheckBox.setSelected(false);
    femaleCheckBox.setSelected(true);
  }

  @Override
  public void onClassroomUpdated(ClassRoom classRoom) {
    classroomList.clear();
  //  classroomList.addAll(classroomService.getAllClassroom());
  }

  @Override
  public void onSectionUpdated(Section section) {
    sectionList.clear();
  //  sectionList.addAll(classroomService.getAllSection());
  }

  @Override
  public void onLevelUpdated(Level level) {
    levelList.clear();
  //  levelList.addAll(classroomService.getAllLevel());
  }

  public void goToHome(ActionEvent actionEvent) {}
}
