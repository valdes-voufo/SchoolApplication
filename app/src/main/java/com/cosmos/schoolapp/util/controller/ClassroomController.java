package com.cosmos.schoolapp.util.controller;

import com.cosmos.schoolapp.controller.MyController;
import com.cosmos.schoolapp.util.Loader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class ClassroomController implements MyController {

  protected ConfigurableApplicationContext ctx;

  protected AnchorPane pane;

  @Autowired
  public ClassroomController(ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
  }

  @Override
  public Pane getPane() {
    return pane;
  }

  @Value("classpath:/schoolapp/layout/main/main-right/classroom/classroom.fxml")
  Resource resource;

  @Override
  public Pane buildPaneRecursive() {
    pane = Loader.load(resource, ctx);
    return pane;
  }
}
