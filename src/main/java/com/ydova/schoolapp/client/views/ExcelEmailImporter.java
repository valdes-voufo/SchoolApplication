package com.ydova.schoolapp.client.views;

import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;



public class ExcelEmailImporter {

    // Classe pour représenter un email
    public static class Email {
        private String email;
        private String place;
        private String category;
        private String group;

        public Email(String email, String place, String category, String group) {
            this.email = email;
            this.place = place;
            this.category = category;
            this.group = group;
        }

        // Getters pour la TableView
        public String getEmail() { return email; }
        public String getPlace() { return place; }
        public String getCategory() { return category; }
        public String getGroup() { return group; }
    }

    // Fonction pour importer et afficher les emails depuis un fichier Excel
    public static void importAndDisplayEmailsFromExcel(TableView<Email> tableView) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ouvrir un fichier Excel");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers Excel", "*.xlsx"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            try (FileInputStream fis = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0); // Prend la première feuille
                Iterator<Row> rowIterator = sheet.iterator();
                ObservableList<Email> emails = FXCollections.observableArrayList();
                StringBuilder errors = new StringBuilder();

                // Ignorer la première ligne (en-têtes)
                if (rowIterator.hasNext()) {
                    rowIterator.next();
                }

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    if (row.getPhysicalNumberOfCells() >= 4) { // Vérifie qu'il y a au moins 4 colonnes
                        String email = getCellValueAsString(row.getCell(0));
                        String place = getCellValueAsString(row.getCell(1));
                        String category = getCellValueAsString(row.getCell(2));
                        String group = getCellValueAsString(row.getCell(3));

                        if (email != null && !email.isEmpty()) {
                            emails.add(new Email(email, place, category, group));
                        } else {
                            errors.append("Ligne ").append(row.getRowNum() + 1).append(" : Email manquant\n");
                        }
                    } else {
                        errors.append("Ligne ").append(row.getRowNum() + 1).append(" : Format invalide\n");
                    }
                }

                // Afficher les données dans le tableau principal
                tableView.getColumns().clear();
                tableView.setItems(emails);

                TableColumn<Email, String> emailCol = new TableColumn<>("Email");
                emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

                TableColumn<Email, String> placeCol = new TableColumn<>("Place");
                placeCol.setCellValueFactory(new PropertyValueFactory<>("place"));

                TableColumn<Email, String> categoryCol = new TableColumn<>("Category");
                categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

                TableColumn<Email, String> groupCol = new TableColumn<>("Group");
                groupCol.setCellValueFactory(new PropertyValueFactory<>("group"));

                tableView.getColumns().addAll(emailCol, placeCol, categoryCol, groupCol);

                // Afficher les erreurs s'il y en a
                if (errors.length() > 0) {
                    Alert errorAlert = new Alert(Alert.AlertType.WARNING);
                    errorAlert.setTitle("Erreurs de format");
                    errorAlert.setHeaderText("Certaines lignes sont mal formatées");
                    errorAlert.setContentText(errors.toString());
                    errorAlert.showAndWait();
                }

                // Créer une nouvelle fenêtre pour afficher les emails
                Stage stage = new Stage();
                stage.setTitle("Emails Importés");

                // Créer un nouveau TableView dans cette fenêtre
                TableView<Email> confirmationTable = new TableView<>();
                confirmationTable.setItems(emails);

                TableColumn<Email, String> emailColConfirmation = new TableColumn<>("Email");
                emailColConfirmation.setCellValueFactory(new PropertyValueFactory<>("email"));

                TableColumn<Email, String> placeColConfirmation = new TableColumn<>("Place");
                placeColConfirmation.setCellValueFactory(new PropertyValueFactory<>("place"));

                TableColumn<Email, String> categoryColConfirmation = new TableColumn<>("Category");
                categoryColConfirmation.setCellValueFactory(new PropertyValueFactory<>("category"));

                TableColumn<Email, String> groupColConfirmation = new TableColumn<>("Group");
                groupColConfirmation.setCellValueFactory(new PropertyValueFactory<>("group"));

                confirmationTable.getColumns().addAll(emailColConfirmation, placeColConfirmation, categoryColConfirmation, groupColConfirmation);

                VBox vbox = new VBox(confirmationTable);
                Scene scene = new Scene(vbox, 600, 400);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Erreur");
                errorAlert.setHeaderText("Erreur lors de la lecture du fichier Excel");
                errorAlert.setContentText(e.getMessage());
                errorAlert.showAndWait();
            }
        }
    }

    // Méthode pour obtenir la valeur d'une cellule sous forme de chaîne
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue()); // Convertit les nombres en entiers
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
