package com.ydova.schoolapp.client.components;

import com.almasb.fxgl.entity.level.LevelLoader;
import com.ydova.schoolapp.server.entity.Level;
import com.ydova.schoolapp.server.service.SchoolService;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LevelDialog {

    public static void createDialog(Level level, SchoolService schoolService, String title ) {


        Stage formStage = new Stage();
        formStage.initModality(Modality.APPLICATION_MODAL);
        formStage.setTitle(title);

        // Header with a blue background
        Label header = new Label(title);
        header.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 16px; -fx-padding: 10px;");
        header.setMaxWidth(Double.MAX_VALUE);
        header.setAlignment(javafx.geometry.Pos.CENTER);

        // ID Field (Non-editable)
        Label idLabel = new Label("ID:");
        TextField idField = new TextField(""+level.getLevelID());
        idField.setEditable(false);

        // Name Field
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField(level.getName());

        // Name Field
        Label sectionsLabel = new Label("Secrions:");
        ComboBox<Level> section = new ComboBox<>(FXCollections.observableArrayList(schoolService.readAllLevels()));


        // Buttons
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");
        Button deleteButton = new Button("Delete");

        HBox buttonBox = new HBox(10,deleteButton ,saveButton, cancelButton);


        // Layout
        VBox formLayout = new VBox(10, header, idLabel, idField, nameLabel, nameField, buttonBox);
        formLayout.setStyle("-fx-padding: 20;");

        // Button Actions
        saveButton.setOnAction (se -> {
            level.setName(nameField.getText());
            level.setSectionID(section.getValue().getSectionID());
            schoolService.updateLevel(level);
            formStage.close();
        });


        deleteButton.setOnAction(e -> {
            schoolService.deleteLevel(level.getLevelID());
            formStage.close();
        });

        cancelButton.setOnAction(e -> formStage.close());







        // Set Scene
        formStage.setScene(new Scene(formLayout, 500, 500));
        formStage.showAndWait();

    }
}
