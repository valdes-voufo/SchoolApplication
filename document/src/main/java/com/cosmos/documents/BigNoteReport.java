package com.cosmos.documents;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.BorderRadius;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;

public class BigNoteReport {
  public static void main(String[] args) {
    try {
      // Create a new PDF document
      PdfDocument pdf = new PdfDocument(new PdfWriter("bulletin.pdf"));

      // Create a new document to add content
      Document document = new Document(pdf);

      // Set font
      PdfFont font = PdfFontFactory.createFont();

      // Set page properties
      document.setMargins(40, 40, 40, 40);

      // Add a title
      // Create a table
      Table header =
          new Table(new float[] {1, 1, 1, 1, 1})
              .setWidth(540)
              .setHorizontalAlignment(HorizontalAlignment.CENTER);

      Cell header_left = new Cell();
      header_left.add(
          new Paragraph("Republique du cameroun\n").setTextAlignment(TextAlignment.CENTER));
      header_left.add(
          new Paragraph("paix - trvail -patrie\n").setTextAlignment(TextAlignment.CENTER));
      header_left.add(
          new Paragraph("Ministere des Enseignement Secondaire\n")
              .setTextAlignment(TextAlignment.CENTER));
      header_left.add(
          new Paragraph("Ecole publique la Bravoure\n").setTextAlignment(TextAlignment.CENTER));
      header_left.setBorder(Border.NO_BORDER);
      header.addCell(header_left);
      header_left.setWidth(200);

      Cell header_center = new Cell();
      Image image =
          new Image(
              ImageDataFactory.create(
                  "src/main/java/com/cosmos/schoolapp/documents/LA BRAVOURE-01.png"));
      image.setWidth(140);
      image.setHeight(100);
      header_center.add(image);
      header_center.setWidth(140);
      header_center.setBorder(Border.NO_BORDER);
      header.addCell(header_center);

      Cell header_right = new Cell();
      header_right.add(
          new Paragraph("Republic of Camerun\n").setTextAlignment(TextAlignment.CENTER));
      header_right.add(
          new Paragraph("peace - Work - Fatherland\n").setTextAlignment(TextAlignment.CENTER));
      header_right.add(
          new Paragraph("Ministry of Secondary\n").setTextAlignment(TextAlignment.CENTER));
      header_right.add(new Paragraph("Education\n").setTextAlignment(TextAlignment.CENTER));
      header_right.add(
          new Paragraph("Primary School la Bravoure\n").setTextAlignment(TextAlignment.CENTER));
      header_right.setBorder(Border.NO_BORDER);
      header_right.setWidth(200);
      header.addCell(header_right);
      header.setBorder(Border.NO_BORDER);
      header.setBorderRadius(new BorderRadius(0));
      header.setBorderLeft(Border.NO_BORDER);
      document.add(header);
      // Create a table
      Table table =
          new Table(new float[] {1, 1, 1, 1})
              .setWidth(540)
              .setHorizontalAlignment(HorizontalAlignment.CENTER);

      // Add table headers
      table.addHeaderCell(createCell("Num", font, true));
      table.addHeaderCell(createCell("Noms et Prenoms", font, true));
      table.addHeaderCell(createCell("Status", font, true));
      table.addHeaderCell(createCell("Note", font, true));

      // Add table rows
      for (int i = 1; i <= 100; i++) {
        table.addCell(createCell(String.valueOf(i), font, false));
        table.addCell(createCell("Dongmo Voufo Sagesse Valdes", font, false));
        table.addCell(createCell("Approved", font, false));
        table.addCell(createCell(String.valueOf(i % 20), font, false));
      }

      // Add the table to the document
      document.add(table);

      // Close the document
      document.close();

      System.out.println("Big Note Report created successfully!");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static Cell createCell(String text, PdfFont font, boolean isHeader) {
    Cell cell = new Cell().add(new Paragraph(text).setFont(font));

    if (isHeader) {
      cell.setBackgroundColor(new DeviceGray(0.75f));
    }

    return cell;
  }
}
