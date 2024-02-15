package com.cosmos.schoolapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Level {

  @Id @GeneratedValue private long levelID;

  @NotNull private String name;

  private long sectionID;

  private double SchoolFees;

  @Override
  public String toString() {
    return name;
  }
}
