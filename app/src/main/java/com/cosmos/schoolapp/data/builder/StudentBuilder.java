package com.cosmos.schoolapp.data.builder;

import com.cosmos.schoolapp.data.entity.Student;
import com.cosmos.schoolapp.data.Gender;
import com.cosmos.schoolapp.data.StudentStatus;

import java.time.LocalDate;

public class StudentBuilder {

  public static Student student;

  public StudentBuilder() {
    student = new Student();
  }

  public Student build() {
    return student;
  }

  public StudentBuilder setMotherEmail(String motherEmail) {
    student.motherEmail = motherEmail;
    return this;
  }

  public StudentBuilder setMotherJob(String motherJob) {
    student.motherJob = motherJob;
    return this;
  }

  public StudentBuilder setFatherJob(String fatherJob) {
    student.fatherJob = fatherJob;
    return this;
  }

  public StudentBuilder setFatherAdress(String fatherAdress) {
    student.fatherAdress = fatherAdress;
    return this;
  }

  public StudentBuilder setMotherAdress(String motherAdress) {
    student.motherAdress = motherAdress;
    return this;
  }

  public StudentBuilder setStudentId(long studentId) {
    student.studentId = studentId;
    return this;
  }

  public StudentBuilder setLastname(String lastname) {
    student.lastname = lastname;
    return this;
  }

  public StudentBuilder setAdresse(String adresse) {
    student.adresse = adresse;
    return this;
  }

  public StudentBuilder setFirstname(String firstname) {
    student.firstname = firstname;
    return this;
  }

  public StudentBuilder setBirthPlace(String birthPlace) {
    student.birthPlace = birthPlace;
    return this;
  }

  public StudentBuilder setBirthDate(LocalDate birthDate) {
    student.birthDate = birthDate;
    return this;
  }

  public StudentBuilder setGender(Gender gender) {
    student.gender = gender;
    return this;
  }

  public StudentBuilder setStatus(StudentStatus status) {
    student.status = status;
    return this;
  }

  public StudentBuilder setClassRoom(long classRoom) {
    student.classRoom = classRoom;
    return this;
  }

  public StudentBuilder setMotherNumber(String motherNumber) {
    student.motherNumber = motherNumber;
    return this;
  }

  public StudentBuilder setFatherNumber(String fatherNumber) {
    student.fatherNumber = fatherNumber;
    return this;
  }

  public StudentBuilder setFatherName(String fatherName) {
    student.fatherName = fatherName;
    return this;
  }

  public StudentBuilder setFatherEmail(String parentEmail) {
    student.fatherEmail = parentEmail;
    return this;
  }

  public StudentBuilder setMotherName(String motherName) {
    student.motherName = motherName;
    return this;
  }

  public StudentBuilder setEnrollmentDate(LocalDate enrollmentDate) {
    student.enrollmentDate = enrollmentDate;
    return this;
  }

  public StudentBuilder setStudentFee(Double studentFee) {
    student.studentFee = studentFee;
    return this;
  }

  public StudentBuilder setNumber(int number) {
    student.number = number;
    return this;
  }
}
