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
public class Section {

  @Id @GeneratedValue private long sectionID;

  @NotNull private String name;

  @Override
  public String toString() {
    return name;
  }
}
