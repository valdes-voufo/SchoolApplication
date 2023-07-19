package com.cosmos.schoolapp.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Generated;

@Entity
@Table
public class ClassRoom {

  @Id @GeneratedValue
  private long classRoomID;

  @NotNull private String name;

  @NotNull public long levelID;


  public long getClassRoomID() {
    return classRoomID;
  }

  public void setClassRoomID(long classRoomID) {
    this.classRoomID = classRoomID;
  }

  public long getLevelID() {
    return levelID;
  }

  public void setLevelID(long levelID) {
    this.levelID = levelID;
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
