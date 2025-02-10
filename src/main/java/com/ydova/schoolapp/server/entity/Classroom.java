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
public class Classroom {

  @Id
  @GeneratedValue
  private Long classRoomID;
  private String name;
  private Long levelID;

  @Override
  public String toString() {
    return name;
  }
}
