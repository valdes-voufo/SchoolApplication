package com.cosmos.schoolapp.controller.task;

import com.cosmos.schoolapp.data.DataMill;
import com.cosmos.schoolapp.data.entity.ClassRoom;
import com.cosmos.schoolapp.data.entity.Level;
import com.cosmos.schoolapp.data.entity.Section;
import com.cosmos.schoolapp.data.entity.Student;
import com.cosmos.schoolapp.data.observer.ClassroomDataObserver;
import com.cosmos.schoolapp.data.observer.LevelDataObserver;
import com.cosmos.schoolapp.data.observer.SectionDataObserver;
import com.cosmos.schoolapp.service.ClassroomService;
import com.cosmos.schoolapp.util.Loader;
import com.cosmos.schoolapp.data.Gender;
import com.cosmos.schoolapp.service.StudentService;
import com.cosmos.schoolapp.util.AlertBuilder;
import com.cosmos.schoolapp.controller.MyController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.Year;
import java.util.Optional;
import java.util.ResourceBundle;

// @Controller
@Component
public class InscriptionController
    implements Initializable,
        MyController,
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

  @Value("classpath:/schoolapp/layout/main/main-right/inscription/inscription.fxml")
  Resource ressource;

  protected StudentService studentService;

  protected ConfigurableApplicationContext ctx;

  protected Pane pane;

  private ObservableList<Section> sectionList = FXCollections.observableArrayList();
  private ObservableList<Level> levelList = FXCollections.observableArrayList();
  private ObservableList<ClassRoom> classroomList = FXCollections.observableArrayList();
  ClassroomService classroomService;

  @Autowired
  public InscriptionController(
      ClassroomService classroomService,
      StudentService service,
      ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
    this.studentService = service;
    this.classroomService = classroomService;
  }

  @Override
  public Pane getPane() {
    return pane;
  }

  @Override
  public Pane buildPaneRecursive() {
    pane = Loader.load(ressource, ctx);
    return pane;
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    classroomService.addObserver((ClassroomDataObserver) this);
    classroomService.addObserver((SectionDataObserver) this);
    classroomService.addObserver((LevelDataObserver) this);
    classroomList = FXCollections.observableArrayList(classroomService.getAllClassroom());
    sectionList = FXCollections.observableArrayList(classroomService.getAllSection());
    levelList = FXCollections.observableArrayList(classroomService.getAllLevel());
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
        DataMill.studentBuilder()
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

  public void goToHome(ActionEvent actionEvent) {}
}
