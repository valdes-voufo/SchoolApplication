package com.cosmos.schoolapp.controller.task;

import com.cosmos.schoolapp.controller.MainContentController;
import com.cosmos.schoolapp.controller.MyController;
import com.cosmos.schoolapp.util.Loader;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class TaskController implements MyController {
  protected ConfigurableApplicationContext ctx;
  protected AnchorPane pane;
  public Button student;
  public Button cours;
  public Button statistics;
  public Button payment;
  public Button notes;
  public Button inscription;

  protected MainContentController mainContentController;

  TaskController(ConfigurableApplicationContext ctx, MainContentController controller) {
    this.mainContentController = controller;
    this.ctx = ctx;
  }

  public void goToInscription(ActionEvent actionEvent) {

    mainContentController.switchContent(ctx.getBean(InscriptionController.class).getPane());
  }

  public void goToNotes(ActionEvent actionEvent) {

    //   mainContentController.switchContent(ctx.getBean(NoteController.class).getPane());
  }

  public void goToPayment(ActionEvent actionEvent) {
    // mainContentController.switchContent(ctx.getBean(PaymentController.class).getPane());
  }

  public void goToClassroom(ActionEvent actionEvent) {
    mainContentController.switchContent(ctx.getBean(ClassroomController.class).getPane());
  }

  public void goToStudent(ActionEvent actionEvent) {
    //  mainContentController.switchContent(ctx.getBean(MainStudentController.class).getPane());
  }

  public void goToStatics(ActionEvent actionEvent) {}

  @Override
  public Pane getPane() {
    return pane;
  }

  @Value("classpath:/schoolapp/layout/main/main-right/task/task.fxml")
  Resource resource;

  @Override
  public Pane buildPaneRecursive() {
    ctx.getBean(InscriptionController.class).buildPaneRecursive();
    // ctx.getBean(NoteController.class).buildPaneRecursive();
    //  ctx.getBean(PaymentController.class).buildPaneRecursive();
    ctx.getBean(ClassroomController.class).buildPaneRecursive();

    pane = Loader.load(resource, ctx);
    return pane;
  }
}
