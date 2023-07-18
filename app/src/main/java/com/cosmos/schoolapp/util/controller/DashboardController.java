package com.cosmos.schoolapp.util.controller;

import com.cosmos.schoolapp.controller.MyController;
import com.cosmos.schoolapp.scene.Loader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class DashboardController implements MyController {
  ConfigurableApplicationContext ctx;
  private AnchorPane pane;

  public DashboardController(ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
  }

  @Override
  public Pane getPane() {
    return pane;
  }

  @Value("classpath:/schoolapp/layout/main/main-right/dashboard/dashboard.fxml")
  Resource ressource;

  @Override
  public Pane buildPaneRecursive() {
    pane = Loader.load(ressource, ctx);
    return pane;
  }
}
