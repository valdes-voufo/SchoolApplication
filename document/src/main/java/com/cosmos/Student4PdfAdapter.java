package com.cosmos;

import com.cosmos.schoolapp.data.entity.Student;

public class Student4PdfAdapter {
   private Student student ;

   public Student4PdfAdapter(Student student){
       this.student = student ;
   }

 public  String getName(){
       return  student.getLastname()+" "+student.getFirstname() ;
 }

 public String getNumber(){
       return String.valueOf(student.getNumber());
 }

 public String getStatus(){
       return String.valueOf(student.getStatus());
 }

    public String geNote() {
       return ";";
    }
}
