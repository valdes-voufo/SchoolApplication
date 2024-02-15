package com.cosmos;

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

import java.util.List;

public class PdfStudentList {
    private String  documentName ;
    private String country ;
    private String countryEng;
    private String ministry;
    private String ministryEng ;
    private  String school;
    private  String schoolEng;
    private String moto ;
    private  String motoEng;

  private   PdfDocument pdf ;
   private Table studenTable;

   private List<Student4PdfAdapter> studentList ;

 private    PdfFont font;
PdfStudentList(){
            try {
                // Create a new PDF document
                font = PdfFontFactory.createFont();
       new PdfDocument(new PdfWriter(documentName));


        // Create a new document to add content
                Document document = new Document(pdf);

                // Set font


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
                        new Paragraph(country+"\n").setTextAlignment(TextAlignment.CENTER));
                header_left.add(
                        new Paragraph(moto    +"\n").setTextAlignment(TextAlignment.CENTER));
                header_left.add(
                        new Paragraph(ministry+"\n")
                                .setTextAlignment(TextAlignment.CENTER));
                header_left.add(
                        new Paragraph(school+"\n").setTextAlignment(TextAlignment.CENTER));
                header_left.setBorder(Border.NO_BORDER);
                header.addCell(header_left);
                header_left.setWidth(200);

                Cell header_center = new Cell();
                Image image =
                        new Image(
                                ImageDataFactory.create(
                                        "document/src/main/resources/documents/logo_colors.png"));
                image.setWidth(140);
                image.setHeight(100);
                header_center.add(image);
                header_center.setWidth(140);
                header_center.setBorder(Border.NO_BORDER);
                header.addCell(header_center);

                Cell header_right = new Cell();
                header_right.add(
                        new Paragraph(country+"\n").setTextAlignment(TextAlignment.CENTER));
                header_right.add(
                        new Paragraph(motoEng+"\n").setTextAlignment(TextAlignment.CENTER));
                header_right.add(
                        new Paragraph(ministryEng+"\n").setTextAlignment(TextAlignment.CENTER));
                header_right.add(new Paragraph("Education\n").setTextAlignment(TextAlignment.CENTER));
                header_right.add(
                        new Paragraph(ministryEng+"\n").setTextAlignment(TextAlignment.CENTER));
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
                 addtableHeader();

                // Add table rows
                studentList.forEach(student -> addStudent(student));


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


    private void addtableHeader(){
        studenTable.addHeaderCell(createCell("Num", font, true));
        studenTable.addHeaderCell(createCell("Noms et Prenoms", font, true));
        studenTable.addHeaderCell(createCell("Status", font, true));
        studenTable.addHeaderCell(createCell("Note", font, true));
    }
      private void addStudent(Student4PdfAdapter student){
          studenTable.addCell(createCell(student.getNumber(), font, false));
          studenTable.addCell(createCell(student.getName(),font,false));
          studenTable.addCell(createCell(student.getStatus(),  font, false));
          studenTable.addCell(createCell(student.geNote(), font, false));
      }
}
