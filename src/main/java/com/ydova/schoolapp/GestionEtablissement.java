package com.ydova.schoolapp;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionEtablissement {

    // Méthode pour créer un fichier Excel
    public static void creerFichierExcel(String cheminFichier, String section, String niveau, String matiere, List<String> eleves) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Liste des élèves");

        // Créer la ligne d'entête
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Section");
        header.createCell(1).setCellValue("Niveau");
        header.createCell(2).setCellValue("Matière");

        // Remplir les détails de la section, du niveau et de la matière
        Row details = sheet.createRow(1);
        details.createCell(0).setCellValue(section);
        details.createCell(1).setCellValue(niveau);
        details.createCell(2).setCellValue(matiere);

        // Créer l'en-tête pour la liste des élèves
        Row titleRow = sheet.createRow(3);
        titleRow.createCell(0).setCellValue("Nom de l'élève");
        titleRow.createCell(1).setCellValue("Note");

        // Ajuster la largeur des colonnes pour permettre des noms complets longs
        sheet.setColumnWidth(0, 10000); // Colonne pour le nom de l'élève
        sheet.setColumnWidth(1, 4000);  // Colonne pour la note

        // Ajouter les élèves
        int rowIndex = 4;
        for (String eleve : eleves) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(eleve);
            row.createCell(1).setCellValue(""); // Champ vide pour la note
        }

        // Rendre les champs de section, niveau et matière non modifiables

        workbook.lockStructure();

        // Écrire le fichier Excel
        try (FileOutputStream fileOut = new FileOutputStream(cheminFichier)) {
            workbook.write(fileOut);
        }

        workbook.close();
    }

    // Méthode pour lire les notes depuis un fichier Excel
    public static List<String[]> extraireNotes(String cheminFichier) throws IOException {
        List<String[]> resultats = new ArrayList<>();

        try (FileInputStream fileIn = new FileInputStream(cheminFichier);
             XSSFWorkbook workbook = new XSSFWorkbook(fileIn)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 4; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    String nomEleve = row.getCell(0).getStringCellValue();
                    String note = row.getCell(1).getStringCellValue();
                    resultats.add(new String[]{nomEleve, note});
                }
            }
        }

        return resultats;
    }

    public static void main(String[] args) {
        String cheminFichier = "liste_eleves.xlsx";
        String section = "Section A";
        String niveau = "Terminale";
        String matiere = "Mathématiques";

        List<String> eleves = List.of("Jean Dupont", "Marie Curie", "Albert Einstein", "Isaac Newton");

        try {
            creerFichierExcel(cheminFichier, section, niveau, matiere, eleves);
            System.out.println("Fichier Excel créé avec succès.");

            // Exemple de lecture des notes après remplissage
            List<String[]> resultats = extraireNotes(cheminFichier);
            for (String[] resultat : resultats) {
                System.out.println("Élève: " + resultat[0] + ", Note: " + resultat[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
