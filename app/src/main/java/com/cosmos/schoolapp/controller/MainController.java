package com.cosmos.schoolapp.controller;

import com.cosmos.schoolapp.controller.task.InscriptionController;
import com.cosmos.schoolapp.controller.task.StudentController;
import com.cosmos.schoolapp.controller.task.TaskController;
import com.cosmos.schoolapp.util.Loader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class MainController implements MyController {
  private final ConfigurableApplicationContext ctx;
  private BorderPane pane;

  @Autowired
  public MainController(ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
  }

  @Override
  public BorderPane getPane() {
    return pane;
  }

  @Value("classpath:/schoolapp/layout/main/main.fxml")
  Resource resource;

  @Override
  public BorderPane buildPaneRecursive() {
    ctx.getBean(TaskController.class).buildPaneRecursive();
    ctx.getBean(StudentController.class).buildPaneRecursive();

    pane = Loader.load(resource, ctx);

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
    switchContent(ctx.getBean(TaskController.class).getPane());
  }

  public void goToOthers(ActionEvent actionEvent) {
    //  mainContentController.switchContent(ctx.getBean(StudentController.class).getPane());
  }

  public void goToStudent(ActionEvent actionEvent) {
    switchContent(ctx.getBean(StudentController.class).getPane());
  }

  public void switchContent(Parent newContent) {
    pane.setCenter(newContent);
  }
}
