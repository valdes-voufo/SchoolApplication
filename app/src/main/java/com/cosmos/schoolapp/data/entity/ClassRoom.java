package com.cosmos.schoolapp.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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

  @Id @GeneratedValue public long classRoomID;

  @NotNull private String name;

  public long levelID;

  @Override
  public String toString() {
    return name;
  }
}
