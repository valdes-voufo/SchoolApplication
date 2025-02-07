package com.ydova.schoolapp;



import com.ydova.schoolapp.client.views.Views;
import com.ydova.schoolapp.client.views.ViewsFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class SchoolApp extends Application {
  @Override
  public void start(Stage primaryStage) {


    BorderPane mainView = (BorderPane) ViewsFactory.getInstance(Views.MAIN);
    ViewsFactory.getInstance(Views.SCHOOL);



    Scene scene = new Scene(mainView, 1200, 900);
    primaryStage.setScene(scene);
    primaryStage.setTitle("College des  Arts et Metier De Loum");
    primaryStage.requestFocus();
    primaryStage.toFront();
    primaryStage.show();
   // primaryStage.setFullScreen(true);

  }

  public static void main(String[] args) {
    launch(args); // Starts the JavaFX application
  }
}
