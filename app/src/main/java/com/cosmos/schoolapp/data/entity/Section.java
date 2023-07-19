package com.cosmos.schoolapp.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table
public class Section {

  @Id @GeneratedValue private long sectionID;

  @NotNull private String name;

  public long getSectionID() {
    return sectionID;
  }

  public void setSectionID(long sectionID) {
    this.sectionID = sectionID;
  }

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
