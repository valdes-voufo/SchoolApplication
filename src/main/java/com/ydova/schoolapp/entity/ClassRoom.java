package com.ydova.schoolapp.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class ClassRoom {

  public long classRoomID;

  private String name;

  public long levelID;

  @Override
  public String toString() {
    return name;
  }
}
