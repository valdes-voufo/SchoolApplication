package com.cosmos.schoolapp.controller;

import com.cosmos.schoolapp.controller.task.TaskController;
import com.cosmos.schoolapp.util.Loader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class MainContentController implements MyController {
  @Value("classpath:/schoolapp/layout/main/main-right/main-right.fxml")
  Resource resource;

  private StackPane pane;
  ConfigurableApplicationContext ctx;

  public MainContentController(ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
  }

  @Override
  public Pane getPane() {
    return pane;
  }

  @Override
  public Pane buildPaneRecursive() {
    ctx.getBean(TaskController.class).buildPaneRecursive();

    pane = Loader.load(resource, ctx);
    AnchorPane SubPane = (AnchorPane) pane.getChildren().get(0);
    VBox box = (VBox) SubPane.getChildren().get(0);
    box.getChildren().add(1, ctx.getBean(TaskController.class).getPane());
    return pane;
  }

  public void switchContent(Parent newContent) {
    AnchorPane SubPane = (AnchorPane) pane.getChildren().get(0);
    VBox box = (VBox) SubPane.getChildren().get(0);
    box.getChildren().remove(1);
    box.getChildren().add(1, newContent);
  }
}
