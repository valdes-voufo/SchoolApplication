package com.ydova.schoolapp.client.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class MainController implements Controller {


 public MainController() {

 }






  public void gotToOthers(MouseEvent mouseEvent) {}

 @FXML
  public void goToHome(ActionEvent actionEvent) {
    //  mainContentController.switchContent(ctx.getBean(HomePageController.class).getPane());
  }

  public void goToDashboard(ActionEvent actionEvent) {
    //  mainContentController.switchContent(ctx.getBean(DashboardController.class).getPane());
  }

  public void goToTask(ActionEvent actionEvent) {

  }



  public void goToStudent(ActionEvent actionEvent) {


}


 public void goToSchool(ActionEvent actionEvent) {
  switchContent((Parent)ViewsFactory.getInstance(Views.SCHOOL));
 }

 public void switchContent(Parent newContent) {
   BorderPane main = (BorderPane) ViewsFactory.getInstance(Views.MAIN);
     assert main != null;
     main.setCenter(newContent);
 }

 }
