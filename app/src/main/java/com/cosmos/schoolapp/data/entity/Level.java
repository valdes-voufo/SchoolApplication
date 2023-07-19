package com.cosmos.schoolapp.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table
public class Level {

  @Id @GeneratedValue private long levelID;

  @NotNull private String name;

  @NotNull private long sectionID;

  public long getLevelID() {
    return levelID;
  }

  public long getSectionID() {
    return sectionID;
  }

  public void setSectionID(long sectionID) {
    this.sectionID = sectionID;
  }

  public void setLevelID(long levelID) {
    this.levelID = levelID;
  }

  public double getSchoolFees() {
    return SchoolFees;
  }

  public void setSchoolFees(double schoolFees) {
    SchoolFees = schoolFees;
  }

  private double SchoolFees;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
