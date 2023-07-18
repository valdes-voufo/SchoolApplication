package com.cosmos.schoolapp.data.entity;

import com.cosmos.schoolapp.data.Gender;
import com.cosmos.schoolapp.data.StudentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table
public class Student {
  @Id @GeneratedValue public long studentId;
  public String lastname;
  public String adresse;

  public String firstname;
  public String birthPlace;
  public LocalDate birthDate;
  public String fatherEmail;

  public void setFatherEmail(String fatherEmail) {
    this.fatherEmail = fatherEmail;
  }

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
  public String fatherAdress;
  public String motherAdress;
  public String motherName;

  public String getMotherEmail() {
    return motherEmail;
  }

  public void setMotherEmail(String motherEmail) {
    this.motherEmail = motherEmail;
  }

  public String getMotherJob() {
    return motherJob;
  }

  public void setMotherJob(String motherJob) {
    this.motherJob = motherJob;
  }

  public String getFatherJob() {
    return fatherJob;
  }

  public void setFatherJob(String fatherJob) {
    this.fatherJob = fatherJob;
  }

  public String getFatherAdress() {
    return fatherAdress;
  }

  public void setFatherAdress(String fatherAdress) {
    this.fatherAdress = fatherAdress;
  }

  public String getMotherAdress() {
    return motherAdress;
  }

  public void setMotherAdress(String motherAdress) {
    this.motherAdress = motherAdress;
  }

  public LocalDate enrollmentDate;
  public Double studentFee;
  public int number;

  public String getFullName() {
    return this.lastname + " " + this.firstname;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

  public long getStudentId() {
    return studentId;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getBirthPlace() {
    return birthPlace;
  }

  public void setBirthPlace(String birthPlace) {
    this.birthPlace = birthPlace;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public StudentStatus getStatus() {
    return status;
  }

  public void setStatus(StudentStatus status) {
    this.status = status;
  }

  public long getClassRoom() {
    return classRoom;
  }

  public void setClassRoom(long classRoom) {
    this.classRoom = classRoom;
  }

  public String getMotherNumber() {
    return motherNumber;
  }

  public void setMotherNumber(String motherNumber) {
    this.motherNumber = motherNumber;
  }

  public String getFatherNumber() {
    return fatherNumber;
  }

  public void setFatherNumber(String fatherNumber) {
    this.fatherNumber = fatherNumber;
  }

  public String getFatherName() {
    return fatherName;
  }

  public void setFatherName(String fatherName) {
    this.fatherName = fatherName;
  }

  public String getParentEmail() {
    return parentEmail;
  }

  public void setParentEmail(String parentEmail) {
    this.parentEmail = parentEmail;
  }

  public String getMotherName() {
    return motherName;
  }

  public void setMotherName(String motherName) {
    this.motherName = motherName;
  }

  public LocalDate getEnrollmentDate() {
    return enrollmentDate;
  }

  public void setEnrollmentDate(LocalDate enrollmentDate) {
    this.enrollmentDate = enrollmentDate;
  }

  public Double getStudentFee() {
    return studentFee;
  }

  public void setStudentFee(Double studentFee) {
    this.studentFee = studentFee;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

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

  public String getFatherEmail() {
    return this.fatherEmail;
  }
}
