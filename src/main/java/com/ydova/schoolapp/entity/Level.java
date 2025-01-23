package com.ydova.schoolapp.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Level {

  private long levelID;

  private String name;

  private long sectionID;

  private double SchoolFees;

  @Override
  public String toString() {
    return name;
  }
}
