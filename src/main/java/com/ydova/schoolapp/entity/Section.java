package com.ydova.schoolapp.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class Section {

  private long sectionID;

  private String name;

  @Override
  public String toString() {
    return name;
  }
}
