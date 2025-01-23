package com.ydova.schoolapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController implements Controller {


 public MainController() {

 }

  BorderPane pane;

  @Override
  public BorderPane getPane() {

    return pane;
  }


  @Override
  public BorderPane buildPaneRecursive()  {
      pane = ControllerUtils.loadPane("layout/main/main.fxml");
      System.out.println("valdes");
  //  ControllerFactory.getInstance(TaskController.class).buildPaneRecursive();
 //   ControllerFactory.getInstance(StudentController.class).buildPaneRecursive();


    return pane;
  }

  public void gotToOthers(MouseEvent mouseEvent) {}

  public void goToHome(ActionEvent actionEvent) {
    //  mainContentController.switchContent(ctx.getBean(HomePageController.class).getPane());
  }

  public void goToDashboard(ActionEvent actionEvent) {
    //  mainContentController.switchContent(ctx.getBean(DashboardController.class).getPane());
  }

  public void goToTask(ActionEvent actionEvent) {
    switchContent(ControllerFactory.getInstance(TaskController.class).getPane());
  }

  public void goToOthers(ActionEvent actionEvent) {
    //  mainContentController.switchContent(ctx.getBean(StudentController.class).getPane());
  }

  public void goToStudent(ActionEvent actionEvent) {
    switchContent(ControllerFactory.getInstance(StudentController.class).getPane());
  }

  public void switchContent(Parent newContent) {
    pane.setCenter(newContent);
  }
}
