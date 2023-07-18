package com.cosmos.schoolapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class SchoolGUI extends Application {
  private ConfigurableApplicationContext context;

  @Override
  public void start(Stage stage) throws Exception {
    context.publishEvent(new StageReadyEvent(stage));
  }

  @Override
  public void init() throws Exception {
    context = new SpringApplicationBuilder(SchoolApp.class).run();
  }

  @Override
  public void stop() throws Exception {
    context.close();
    Platform.exit();
  }
}
