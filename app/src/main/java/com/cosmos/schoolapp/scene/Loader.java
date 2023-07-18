package com.cosmos.schoolapp.scene;

import com.cosmos.schoolapp.SchoolApp;
import com.cosmos.schoolapp.SchoolGUI;
import javafx.fxml.FXMLLoader;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URL;

public class Loader {

  /*
   * public static AnchorPane tasks = (AnchorPane) load("layout/main/main-right/task/task.fxml");
   *
   * public static AnchorPane mainNavbar = ; public static StackPane mainContent = ; public static StackPane student;
   * public static AnchorPane dashboard = (AnchorPane) load("layout/main/main-right/dashboard/dashboard.fxml"); public
   * static ScrollPane notePage = (ScrollPane) load("layout/main/main-right/notes/notes-page.fxml"); public static
   * AnchorPane inscription =(AnchorPane) load( "layout/main/main-right/inscription/inscription.fxml");
   *
   * static { SceneLoader.mainScene.getItems().setAll(SceneLoader.mainNavbar, SceneLoader.mainContent); AnchorPane
   * pane = (AnchorPane) SceneLoader.mainContent.getChildren().get(0); VBox box = (VBox) pane.getChildren().get(0);
   * box.getChildren().add(home); }
   */

  public static <T> T load(Resource resource, ConfigurableApplicationContext ctx) {
    FXMLLoader loader = new FXMLLoader();
    loader.setControllerFactory(ctx::getBean);
    // loader.setResources(resourceBundle);
    try {
      loader.setLocation(resource.getURL());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      return loader.load();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
