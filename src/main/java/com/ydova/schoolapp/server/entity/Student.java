package com.ydova.schoolapp.server.entity;



import com.ydova.schoolapp.client.utils.Gender;
import com.ydova.schoolapp.client.utils.StudentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Entity
public class Student {
  @Id @GeneratedValue
  private Long studentId;
    private String lastname;
    private String adresse;

    private String firstname;
    private String birthPlace;
    private LocalDate birthDate;
    private String fatherEmail;

    private Gender gender;
    private StudentStatus status;
    private long classRoom;
    private String motherNumber;
    private String fatherNumber;
    private String fatherName;
    private String parentEmail;
    private String motherEmail;
    private String motherJob;
    private String fatherJob;
    private String fatherAddress;
    private String motherAddress;
    private String motherName;

    private LocalDate enrollmentDate;
    private Double studentFee;
    private int number;

  @Override
  public String toString() {
    return "Student{"
        + "studentId='"
        + studentId
        + '\''
        + ", lastname='"
        + lastname
        + '\''
        + ", firstname='"
        + firstname
        + '\''
        + ", birthPlace='"
        + birthPlace
        + '\''
        + ", birthDate="
        + birthDate
        + ", gender="
        + gender
        + ", status="
        + status
        + ", classRoom="
        + classRoom
        + ", motherNumber='"
        + motherNumber
        + '\''
        + ", fatherNumber='"
        + fatherNumber
        + '\''
        + ", fatherName='"
        + fatherName
        + '\''
        + ", parentEmail='"
        + parentEmail
        + '\''
        + ", motherName='"
        + motherName
        + '\''
        + '}';
  }
}
