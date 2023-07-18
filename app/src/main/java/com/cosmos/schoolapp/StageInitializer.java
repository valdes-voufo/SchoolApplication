package com.cosmos.schoolapp;

import com.cosmos.schoolapp.controller.MainController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {
  private MainController main;

  @Value("${spring.application.ui.title}")
  private String applicationTitle;

  private final ConfigurableApplicationContext context;

  @Autowired
  public StageInitializer(ConfigurableApplicationContext context) {
    this.context = context;
  }

  @Override
  public void onApplicationEvent(StageReadyEvent event) {
    main = context.getBean(MainController.class);

    Stage stage = event.getStage();

    stage.setTitle(applicationTitle);
    stage.setScene(new Scene(main.buildPaneRecursive(), 1200, 800));
    stage.show();
  }
}
