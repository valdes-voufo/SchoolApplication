package com.ydova.schoolapp;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloVApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Main layout
        BorderPane root = new BorderPane();

        // List of students (on the left)
        ListView<String> studentList = new ListView<>();
        studentList.getItems().addAll("John Doe", "Jane Smith", "Emily Davis");

        Button addStudentButton = new Button("Add Student");
        VBox leftPane = new VBox(10, studentList, addStudentButton);
        leftPane.setPadding(new Insets(10));
        root.setLeft(leftPane);

        // Dialog for adding a student (on the right)
        VBox addStudentDialog = createAddStudentDialog();
        addStudentDialog.setTranslateX(300); // Initially off-screen
        root.getChildren().add(addStudentDialog);

        // Button action to show the dialog
        addStudentButton.setOnAction(event -> slideInDialog(addStudentDialog));

        // Scene and Stage
        Scene scene = new Scene(root, 800, 400);
        primaryStage.setTitle("Student Management");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createAddStudentDialog() {
        VBox dialog = new VBox(10);
        dialog.setPadding(new Insets(20));
        dialog.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #cccccc;");
        dialog.setPrefWidth(300);

        Label title = new Label("Add Student");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter student name");

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            System.out.println("Student saved: " + nameField.getText());
            nameField.clear();
        });

        dialog.getChildren().addAll(title, nameField, saveButton);
        return dialog;
    }

    private void slideInDialog(VBox dialog) {
        TranslateTransition transition = new TranslateTransition(Duration.millis(300), dialog);
        transition.setFromX(300); // Start off-screen
        transition.setToX(0);    // Slide into view
        transition.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
