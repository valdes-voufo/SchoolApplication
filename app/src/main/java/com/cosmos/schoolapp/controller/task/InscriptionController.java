package com.cosmos.schoolapp.controller.task;

import com.cosmos.schoolapp.entity.ClassRoom;
import com.cosmos.schoolapp.entity.Student;
import com.cosmos.schoolapp.scene.Loader;
import com.cosmos.schoolapp.schoolModel.people.person.Gender;
import com.cosmos.schoolapp.schoolModel.people.student.StudentStatus;
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
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

// @Controller
@Controller
public class InscriptionController implements Initializable, MyController {
  @Value("classpath:/schoolapp/layout/main/main-right/inscription/inscription.fxml")
  Resource ressource;

  protected StudentService studentService;

  protected ConfigurableApplicationContext ctx;

  protected Pane pane;

  public TextField lastname;
  public TextField firstname;
  public DatePicker dateOfBirth;
  public TextField placeOfBirth;
  public TextField fatherName;
  public TextField fatherNumber;
  public TextField motherName;
  public TextField motherNumber;
  public TextField parentEmail;
  public TextField fee;
  public DatePicker enrollmentDate;
  public ComboBox<Gender> gender;
  public ComboBox<ClassRoom> classroom;
  public ComboBox<StudentStatus> status;

  List<TextField> textFields;

  @Autowired
  public InscriptionController(StudentService service, ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
    this.studentService = service;
  }

  public void inscription(ActionEvent actionEvent) throws SQLException {
    Student student = new Student();
    initFieldList();
    if (checkFields()) {
      student.setLastname(lastname.getText());
      student.setFirstname(firstname.getText());
      student.setBirthPlace(placeOfBirth.getText());
      student.setFatherName(fatherName.getText());
      student.setFatherNumber(fatherName.getText());
      student.setMotherName(motherName.getText());
      student.setMotherNumber(motherNumber.getText());
      student.setParentEmail(parentEmail.getText());

      // TODO
      //   student.setClassRoom(ClassRoom.findFirstAvailableClassroom(classroom.getValue()) );
      student.setStatus(status.getValue());
      student.setEnrollmentDate(enrollmentDate.getValue());
      student.setBirthDate(dateOfBirth.getValue());
      student.setGender(gender.getValue());
      student.setNumber(10);
      student.setStudentFee(Double.parseDouble(fee.getText()));

      // clear the field
      textFields.forEach(TextInputControl::clear);
      Alert alert =
          AlertBuilder.alert(
              "Confirmation", "Confirmer L'inscription", Alert.AlertType.CONFIRMATION);
      Optional<ButtonType> result = alert.showAndWait();
      if (result.isPresent() && result.get().getButtonData().isDefaultButton()) {
        studentService.saveStudent(student);
        AlertBuilder.alert(
            "Inscription", "eleve inscrit avec Success", 1, Alert.AlertType.INFORMATION);
      }
    } else {
      Alert alert =
          AlertBuilder.alert("ERREUR", "un des Champ est mal remplis", Alert.AlertType.WARNING);
      alert.showAndWait();
    }
  }

  public void initFieldList() {
    textFields =
        List.of(
            lastname,
            firstname,
            placeOfBirth,
            firstname,
            fatherName,
            fatherNumber,
            motherName,
            motherNumber,
            parentEmail,
            fee);
  }

  private boolean checkFields() {
    return !lastname.getText().isEmpty();
  }

  protected Student getStudent() {
    Student student = new Student();
    student.setLastname("Youndjeu Monga");
    student.setFirstname("Sagesse Valdes");
    student.setBirthPlace("Loum");
    student.setFatherName("Dongmo Papa");
    student.setFatherNumber("01794245387");
    student.setMotherName("Dogmo maman");
    student.setMotherNumber("01794245387");
    student.setParentEmail("valdesvoufo8@gmail.com");
    //  student.setClassRoom(new ClassRoom("CM2_B", Level.CM2));
    student.setStatus(StudentStatus.NONREDOUBLANT);
    student.setEnrollmentDate(LocalDate.of(2023, 1, 2));
    student.setBirthDate(LocalDate.of(2002, 1, 1));
    student.setGender(Gender.FEMININ);
    student.setNumber(10);
    student.setStudentFee(30500.0);
    return student;
  }

  public void save() {

    studentService.saveStudent(getStudent());
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //  gender.setItems(FXCollections.observableArrayList(Gender.values()));

    // classroom.setItems(ClassRoom.extractLevels(ClassRoom.allClasRoomsList));
    //   status.setItems(FXCollections.observableArrayList(StudentStatus.values()));

    // Set the TextFormatter to the TextField
    //  fee.setTextFormatter(new TextFormatter<>(FormularUtils.amountsFilter4TextField()));
    // enrollmentDate.setEditable(false);
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

  public void pictureImport(ActionEvent actionEvent) {}

  public void scolarityPaiement(ActionEvent actionEvent) {}

  public void payedAmount(ActionEvent actionEvent) {}
}
