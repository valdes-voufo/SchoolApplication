package com.cosmos.schoolapp.data.entity;

import com.cosmos.schoolapp.data.Section;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Generated;

@Entity
@Table
public class Level {

  @Id @Generated private long levelID;

  @NotNull private String name;

  @NotNull Section section;

  public long getLevelID() {
    return levelID;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
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
