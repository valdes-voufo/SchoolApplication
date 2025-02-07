package com.ydova.schoolapp.client.components;

import com.ydova.schoolapp.server.entity.Section;
import com.ydova.schoolapp.server.service.SchoolService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SectionDialog {

    public static void createDialog(Section section, SchoolService schoolService, String title ) {


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
        TextField idField = new TextField(""+section.getSectionID());
        idField.setEditable(false);

        // Name Field
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField(section.getName());


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
            section.setName(nameField.getText());
            schoolService.updateSection(section);
            formStage.close();
        });


         deleteButton.setOnAction(e -> {
             schoolService.deleteSection(section.getSectionID());
            formStage.close();
        });

        cancelButton.setOnAction(e -> formStage.close());







        // Set Scene
        formStage.setScene(new Scene(formLayout, 500, 500));
        formStage.showAndWait();

    }
}
