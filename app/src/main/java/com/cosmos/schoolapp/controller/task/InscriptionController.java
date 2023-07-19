package com.cosmos.schoolapp.controller.task;

import com.cosmos.schoolapp.data.builder.StudentBuilder;
import com.cosmos.schoolapp.data.entity.Student;
import com.cosmos.schoolapp.util.Loader;
import com.cosmos.schoolapp.data.Gender;
import com.cosmos.schoolapp.service.StudentService;
import com.cosmos.schoolapp.util.AlertBuilder;
import com.cosmos.schoolapp.controller.MyController;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

// @Controller
@Component
public class InscriptionController implements Initializable, MyController {
  public TextField lastname;
  public TextField firstname;
  public CheckBox maleCheckBox;

  public CheckBox femaleCheckBox;
  public TextField address;

  public DatePicker dateOfBirth;
  public TextField birthPlace;

  @Value("classpath:/schoolapp/layout/main/main-right/inscription/inscription.fxml")
  Resource ressource;

  protected StudentService studentService;

  protected ConfigurableApplicationContext ctx;

  protected Pane pane;

  @Autowired
  public InscriptionController(StudentService service, ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
    this.studentService = service;
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
  public void initialize(URL url, ResourceBundle resourceBundle) {}

  public void performInscription(ActionEvent actionEvent) {

    // check fields that mandatory field are filled
    if (!checkFields()) {
      return;
    }

    // build the new student
    Student student =
        new StudentBuilder()
            .setStudentId(10) // FIXME: 18.07.2023 generate
            .setLastname(lastname.getText())
            .setFirstname(firstname.getText())
            .setGender(getGender())
            .setAdresse(address.getText())
            .setBirthDate(dateOfBirth.getValue())
            .setBirthPlace(birthPlace.getText())
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

  public void CheckMale(ActionEvent actionEvent) {
    femaleCheckBox.setSelected(false);
    maleCheckBox.setSelected(true);
  }

  public void checkFemale(ActionEvent actionEvent) {
    maleCheckBox.setSelected(false);
    femaleCheckBox.setSelected(true);
  }
}
