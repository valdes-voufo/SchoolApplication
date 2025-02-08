package com.ydova.schoolapp.server.entity;

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
public class Section {

  @Id
  @GeneratedValue
  public Long sectionID;

  public String name;

  @Override
  public String toString() {
    return name;
  }
}
