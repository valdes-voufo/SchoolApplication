package com.ydova.schoolapp.client.views;



import com.ydova.schoolapp.client.utils.Gender;
import com.ydova.schoolapp.server.entity.Classroom;
import com.ydova.schoolapp.server.entity.Level;
import com.ydova.schoolapp.server.entity.Section;

import com.ydova.schoolapp.server.entity.Student;
import com.ydova.schoolapp.server.service.SchoolService;


import com.ydova.schoolapp.server.service.ServiceFactory;
import com.ydova.schoolapp.server.service.StudentService;
import com.ydova.schoolapp.client.utils.AlertBuilder;
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
        Controller{
  public TextField lastname;
  public TextField firstname;
  public CheckBox maleCheckBox;

  public CheckBox femaleCheckBox;
  public TextField address;

  public DatePicker dateOfBirth;
  public TextField birthPlace;
  public ImageView profilPicture;
  public ChoiceBox<Year> academicYear;
  public ChoiceBox<Classroom> classRoom;
  public ChoiceBox<Level> level;
  public ChoiceBox<Section> section;

String file = "classpath:/schoolapp/layout/main/main-right/inscription/inscription.fxml";


  protected StudentService studentService;



  protected Pane pane;

  private ObservableList<Section> sectionList = FXCollections.observableArrayList();
  private ObservableList<Level> levelList = FXCollections.observableArrayList();
  private ObservableList<Classroom> classroomList = FXCollections.observableArrayList();
  SchoolService schoolService;

  public InscriptionController() {
    this.schoolService = ServiceFactory.getInstance(SchoolService.class);
  }



  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {

    classroomList = FXCollections.observableArrayList(schoolService.readAllClassrooms());
    sectionList = FXCollections.observableArrayList(schoolService.readAllSections());
    levelList = FXCollections.observableArrayList(schoolService.readAllLevels());
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
            .build();

    if (confirmInscription()) {
      studentService.save(student);
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


  public void goToHome(ActionEvent actionEvent) {}
}
