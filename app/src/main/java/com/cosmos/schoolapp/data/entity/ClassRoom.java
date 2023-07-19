package com.cosmos.schoolapp.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Generated;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
public class ClassRoom {

  @Id @Generated private long classRoomID;

  @NotNull private String name;

  public long levelID;
  public long numberOfStudents;

  @Override
  public String toString() {
    return name;
  }
}
