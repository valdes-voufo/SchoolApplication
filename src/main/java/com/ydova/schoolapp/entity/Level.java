package com.ydova.schoolapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Entity
public class Level {

  @Id
 @ GeneratedValue
  private Long levelID;

  private String name;

  private Long sectionID;

  private double SchoolFees;

  @Override
  public String toString() {
    return name;
  }
}
