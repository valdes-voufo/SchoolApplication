package com.cosmos.schoolapp.controller;

import com.cosmos.schoolapp.controller.task.TaskController;
import com.cosmos.schoolapp.scene.Loader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

@Controller
@Scope("singleton")
public class NavItemController implements MyController {
  @Value("classpath:/schoolapp/layout/main/main-left/navbar.fxml")
  Resource ressource;

  private final ConfigurableApplicationContext ctx;

  MainContentController mainContentController;
  private AnchorPane pane;

  private MainController controller;
  @FXML public Button others; // button

  public Button student;
  public Button task;
  public Button dashboard;
  public Button home;

  @Autowired
  public NavItemController(
      ConfigurableApplicationContext ctx, MainContentController mainController) {
    this.mainContentController = mainController;
    this.ctx = ctx;
  }

  public void gotToOthers(MouseEvent mouseEvent) {}

  public void goToHome(ActionEvent actionEvent) {
  //  mainContentController.switchContent(ctx.getBean(HomePageController.class).getPane());
  }

  public void goToDashboard(ActionEvent actionEvent) {
  //  mainContentController.switchContent(ctx.getBean(DashboardController.class).getPane());
  }

  public void goToTask(ActionEvent actionEvent) {
    mainContentController.switchContent(ctx.getBean(TaskController.class).getPane());
  }

  public void goToOthers(ActionEvent actionEvent) {
  //  mainContentController.switchContent(ctx.getBean(StudentController.class).getPane());
  }

  public void goToStudent(ActionEvent actionEvent) {
 //   mainContentController.switchContent(ctx.getBean(MainStudentController.class).getPane());
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
}
