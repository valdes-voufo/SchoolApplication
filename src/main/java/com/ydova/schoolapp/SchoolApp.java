package com.ydova.schoolapp;



import com.ydova.schoolapp.controller.MainController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SchoolApp extends Application {
  @Override
  public void start(Stage primaryStage) {

    UserDAO.saveUser("sss","sss");

    MainController controller = new MainController();
    controller.buildPaneRecursive();
    Parent root = controller.getPane();

    Scene scene = new Scene(root, 1000, 1000);
    primaryStage.setScene(scene);
    primaryStage.setTitle("JavaFX with FXML");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args); // Starts the JavaFX application
  }
}
