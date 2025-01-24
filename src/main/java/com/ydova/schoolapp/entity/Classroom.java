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
public class Classroom {

  @Id
  @GeneratedValue
  public Long classRoomID;
  private String name;
  public Long levelID;

  @Override
  public String toString() {
    return name;
  }
}
