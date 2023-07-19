package com.cosmos.schoolapp.util.controller;

import com.cosmos.schoolapp.controller.MyController;
import com.cosmos.schoolapp.data.entity.Student;
import com.cosmos.schoolapp.util.messages.NoteMessage;
import com.cosmos.schoolapp.util.Loader;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.*;

@Controller
public class NoteController implements Initializable, MyController {
  private ConfigurableApplicationContext ctx;
  private ScrollPane pane;

  private final Map<Student, TextField> notesMap = new HashMap<>();
  public static List<TextField> allTextFields = new LinkedList<>();
  public static TextField focusTexFiled;
  @FXML public ComboBox<String> sequence;
  @FXML public ComboBox<String> subject;
  @FXML public ComboBox<String> classroom;
  @FXML public TextField idNumber;
  @FXML public VBox vbox;
  @FXML public ScrollPane principal;
  @FXML public Label label;
  private String previousClass;
  private String previousSubject;
  private String previousSequence;

  public NoteController(ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
  }

  public void confirmation(ActionEvent actionEvent) throws SQLException {

    String identification = idNumber.getText();
    if (identification.length() >= 5
        && sequence.getValue() != null
        && classroom.getValue() != null
        && subject.getValue() != null) {
      if (Objects.equals(subject.getValue(), previousSubject)
          && Objects.equals(sequence.getValue(), previousSequence)
          && Objects.equals(classroom.getValue(), previousClass)) {
        label.setTextFill(Color.BLACK);
        label.setText(
            NoteMessage.getFicheCharger(
                classroom.getValue(), subject.getValue(), sequence.getValue()));
        idNumber.clear();
        return;
      }

      idNumber.clear();
      vbox.getChildren().remove(1, vbox.getChildren().size());
      label.setTextFill(Color.BLACK);
      label.setText(
          NoteMessage.getFicheCharger(
              classroom.getValue(), subject.getValue(), sequence.getValue()));
      cloneHbox();
      previousSubject = subject.getValue();
      previousSequence = sequence.getValue();
      previousClass = classroom.getValue();
      allTextFields.get(0).requestFocus();
      focusTexFiled = allTextFields.get(0);

    } else {
      label.setTextFill(Color.RED);
      Font font = Font.font("Sylfaen", 17);
      label.setFont(Font.font(font.getFamily(), FontWeight.BOLD, font.getSize()));
      label.setText(NoteMessage.getChampMalRemplis());
    }
  }

  public void cloneHbox() throws SQLException {

    /*
     * for (Student student : new HashSet<>()) { HBox hboxModel = newHBox(student); allTextFields.add((TextField)
     * hboxModel.getChildren().get(4)); vbox.getChildren().add(hboxModel); }
     */
  }

  public HBox newHBox(Student student) {
    HBox hbox = new HBox();
    hbox.setPrefHeight(45.0);
    hbox.setPrefWidth(889.0);

    Label nomPrenomLabel = createLabel(student.getFirstname(), 54.0, 415.0, Pos.CENTER);
    Label matriculeLabel = createLabel(student.getLastname(), 48.0, 202.0, Pos.CENTER);
    Label matiereLabel = createLabel(subject.getValue(), 54.0, 218.0, Pos.CENTER);
    Label sequenceLabel = createLabel(sequence.getValue(), 56.0, 198.0, Pos.CENTER);

    TextField textField = new TextField();
    textField.setOnKeyPressed(move());
    textField.setOnMouseClicked(
        new EventHandler<MouseEvent>() {
          @Override
          public void handle(MouseEvent event) {
            focusTexFiled = textField;
          }
        });

    textField.setPrefHeight(62.0);
    textField.setPrefWidth(218.0);
    textField.setId(String.valueOf(student.getStudentId()));
    notesMap.put(student, textField);
    hbox.getChildren()
        .addAll(nomPrenomLabel, matriculeLabel, matiereLabel, sequenceLabel, textField);
    return hbox;
  }

  protected EventHandler<KeyEvent> move() {

    return new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {

        int index = allTextFields.indexOf(focusTexFiled);
        if (((KeyEvent) event).getCode() == KeyCode.DOWN) {
          int newIndex = index + 1 % allTextFields.size();

          allTextFields.get(newIndex).requestFocus();
          focusTexFiled = allTextFields.get(newIndex);
        }

        if (((KeyEvent) event).getCode() == KeyCode.UP) {
          int newIndex = index - 1 % allTextFields.size();

          allTextFields.get(newIndex).requestFocus();
          focusTexFiled = allTextFields.get(newIndex);
        }
      }
    };
  }

  public Label createLabel(String name, double height, double width, Pos position) {
    Label newLabel = new Label(name);
    newLabel.setPrefHeight(height);
    newLabel.setPrefWidth(width);
    newLabel.setAlignment(position);
    newLabel.setFont(new Font("Sylfaen", 12.0));

    return newLabel;
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
   // subject.getItems().addAll(Helpers.matieres);
   // sequence.getItems().addAll(Helpers.sequences);
   // classroom.getItems().addAll(Helpers.classes);
    label.setText("Fiche de Notes");
    // focus(AllTextFields);

  }

  public void enregistrer(ActionEvent actionEvent) {
    for (Map.Entry<Student, TextField> noteEntry : notesMap.entrySet()) {
      if ((noteEntry.getValue().getText() != (null))) {
        System.out.println(
            noteEntry.getKey().getFirstname() + ": " + noteEntry.getValue().getText());
      }
    }
  }

  @Override
  public Parent getPane() {
    return pane;
  }

  @Value("classpath:/schoolapp/layout/main/main-right/notes/notes-page.fxml")
  Resource resource;

  @Override
  public Parent buildPaneRecursive() {
    pane = Loader.load(resource, ctx);
    return pane;
  }
}
