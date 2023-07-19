package com.cosmos.schoolapp.data.entity;

import com.cosmos.schoolapp.data.Gender;
import com.cosmos.schoolapp.data.StudentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Student {
  @Id @GeneratedValue public long studentId;
  public String lastname;
  public String adresse;

  public String firstname;
  public String birthPlace;
  public LocalDate birthDate;
  public String fatherEmail;

  public Gender gender;
  public StudentStatus status;
  public long classRoom;
  public String motherNumber;
  public String fatherNumber;
  public String fatherName;
  public String parentEmail;
  public String motherEmail;
  public String motherJob;
  public String fatherJob;
  public String fatherAddress;
  public String motherAddress;
  public String motherName;

  public LocalDate enrollmentDate;
  public Double studentFee;
  public int number;

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
