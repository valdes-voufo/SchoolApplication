package com.cosmos.schoolapp.controller;

import com.cosmos.schoolapp.scene.Loader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class MainController implements MyController {
  private final ConfigurableApplicationContext ctx;
  private SplitPane pane;

  @Autowired
  public MainController(ConfigurableApplicationContext ctx) {
    this.ctx = ctx;
  }

  @Override
  public SplitPane getPane() {
    return pane;
  }

  @Value("classpath:/schoolapp/layout/main/main.fxml")
  Resource resource;

  @Override
  public SplitPane buildPaneRecursive() {

    Pane navItem = ctx.getBean(NavItemController.class).buildPaneRecursive();
    Pane mainRight = ctx.getBean(MainContentController.class).buildPaneRecursive();

    pane = Loader.load(resource, ctx);

    pane.getItems().setAll(navItem, mainRight);
    return pane;
  }
}
