package com.cosmos.schoolapp.util.controller;

import com.cosmos.schoolapp.data.observer.StudentDataObserver;
import com.cosmos.schoolapp.controller.MyController;
import com.cosmos.schoolapp.data.entity.Student;
import com.cosmos.schoolapp.util.Loader;
import com.cosmos.schoolapp.data.Gender;
import com.cosmos.schoolapp.service.ClassroomService;
import com.cosmos.schoolapp.service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

@Controller
public class StudentController implements Initializable, MyController {
  private final ConfigurableApplicationContext ctx;

  private final ClassroomService classroomService;
  private final StudentService studentService;

  private AnchorPane pane;

  @FXML private ChoiceBox<String> academicYear;

  @FXML private DatePicker birthDate;

  @FXML private TextField birthPlace;

  @FXML private TextField classNumber;

  @FXML private ChoiceBox<String> classRoom;

  @FXML private TextField adresse;

  @FXML private TextField fatherAdress;

  @FXML private TextField fatherEmail;

  @FXML private TextField fatherJob;

  @FXML private TextField fatherName;

  @FXML private TextField fatherNumber;

  @FXML private CheckBox masculinCheckBox;
  @FXML private CheckBox femininCheckBox;

  @FXML private TextField idNumber;

  @FXML private TextField leftAmount;

  @FXML private TextField level;

  @FXML private TextField motherAdress;

  @FXML private TextField motherEmail;

  @FXML private TextField motherJob;

  @FXML private TextField motherName;

  @FXML private TextField motherNumber;

  @FXML private TextField name;

  @FXML private TextField payedAmount;

  @FXML private ImageView profilPicture;

  @FXML private TextField scolarityFees;

  @FXML private TextField surname;

  @Autowired
  public StudentController(
      ConfigurableApplicationContext ctx,
      StudentService studentService,
      ClassroomService classroomService) {
    this.ctx = ctx;
    this.classroomService = classroomService;
    this.studentService = studentService;
  }

  @FXML
  void certificatePrint(ActionEvent event) {}

  @FXML
  void payedAmount(ActionEvent event) {
    leftAmount.setText(
        String.valueOf(
            Integer.parseInt(scolarityFees.getText()) - Integer.parseInt(payedAmount.getText())));
  }

  @FXML
  void pictureImport(ActionEvent event) {}

  @FXML
  void receptPrint(ActionEvent event) {}

  public ChoiceBox<?> getAcademicYear() {
    return academicYear;
  }

  @FXML
  void scolarityPaiement(ActionEvent event) {}

  @FXML
  void studentInfosPrint(ActionEvent event) {}

  public void feelStudentsDetails(Student student) throws ChangeSetPersister.NotFoundException {

    name.setText(student.lastname);
    surname.setText(student.firstname);

    if (Objects.equals(student.getGender(), Gender.MALE)) {
      masculinCheckBox.setSelected(true);
      femininCheckBox.setSelected(false);
    } else if (Objects.equals(student.getGender(), Gender.FEMALE)) {
      masculinCheckBox.setSelected(false);
      femininCheckBox.setSelected(true);
    }

    adresse.setText(student.getAdresse());
    birthDate.setValue(student.getBirthDate());
    birthPlace.setText(student.getBirthPlace());
    fatherName.setText(student.getFatherName());
    motherName.setText(student.getMotherName());
    fatherEmail.setText(student.getParentEmail());
    fatherNumber.setText(student.getFatherNumber());
    motherNumber.setText(student.getMotherNumber());
    motherAdress.setText(student.getMotherAddress());
    fatherAdress.setText(student.getFatherAddress());
    fatherJob.setText(student.getFatherJob());
    motherJob.setText(student.getMotherJob());
    motherEmail.setText(student.getMotherEmail());
    fatherEmail.setText(student.getFatherEmail());

    // scolarityFees.setText(String.valueOf(student.classRoom.getLevel().scolarityFees));
    payedAmount.setText(String.valueOf(student.getStudentFee()));

    /*double a= Integer.parseInt(scolarityFees.getText());
    double b    =Integer.parseInt(payedAmount.getText());
       leftAmount.setText( String.valueOf(a-b));*/

    masculinCheckBox.setOnAction(
        event -> {
          if (masculinCheckBox.isSelected()) {
            femininCheckBox.setSelected(false);
          }
        });
    femininCheckBox.setOnAction(
        event -> {
          if (femininCheckBox.isSelected()) {
            masculinCheckBox.setSelected(false);
          }
        });
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    //  classRoom.getItems().addAll(Helpers.classes); fixme
    //  academicYear.getItems().addAll(Helpers.academicYear);
    DatePicker datePicker = new DatePicker();
    datePicker.setValue(LocalDate.of(2023, 6, 19));

    LocalDate selectedDate = datePicker.getValue();
    /* Student student =
    new StudentDataObserver()
        .setStudentFee(30000.0)
        .setAdresse("KAMKOP-BAFOUSSAM")
        .setLastname("NGUETAVA")
        .setFirstname("VANOL")
        .setFatherAdress("KAMKOP-BAFOUSSAM")
        .setMotherAdress("KAMKOP-BAFOUSSAM")
        .setMotherEmail("KJ@gmail.com")
        .setFatherJob("PHILOSOPHE")
        .setMotherJob("ASTRONAUTE")
        .setMotherName("HILARY CLINTON")
        .setFatherName("BILL GATES")
        .setFatherNumber("677889333")
        .setMotherNumber("64874289")
        .setBirthDate(selectedDate)
        .setBirthPlace("BALENG")
        .setGender(Gender.MALE)
        .setFatherEmail("vanol@gmail.com")
        .build();*/

    //  feelStudentsDetails(student);
  }

  @Override
  public Parent getPane() {
    return pane;
  }

  @Value("classpath:/schoolapp/layout/main/main-right/student/student.fxml")
  Resource resource;

  @Override
  public Parent buildPaneRecursive() {
    pane = Loader.load(resource, ctx);
    return pane;
  }
}
