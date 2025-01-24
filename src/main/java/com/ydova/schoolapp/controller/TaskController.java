package com.ydova.schoolapp.controller;

import com.ydova.schoolapp.views.ControllerUtils;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class TaskController implements Controller {

  protected AnchorPane pane;
  public Button student;
  public Button cours;
  public Button statistics;
  public Button payment;
  public Button notes;
  public Button inscription;

  TaskController() {}

  public void goToInscription(ActionEvent actionEvent) {

  }

  public void goToNotes(ActionEvent actionEvent) {

    //
    // mainContentController.switchContent(ControllerFactory.getInstance(NoteController.class).getPane());
  }

  public void goToPayment(ActionEvent actionEvent) {
  /*  ControllerFactory.getInstance(MainController.class)
        .switchContent(ControllerFactory.getInstance(PaymentController.class).getPane());*/
  }

  public void goToClassroom(ActionEvent actionEvent) {

  }

  public void goToStudent(ActionEvent actionEvent) {

  }

  public void goToStatics(ActionEvent actionEvent) {}

  String task = "classpath:/schoolapp/layout/main/main-right/task/task.fxml";


}
