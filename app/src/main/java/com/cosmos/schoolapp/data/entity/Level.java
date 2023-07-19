package com.cosmos.schoolapp.data.entity;

import com.cosmos.schoolapp.data.Section;
import com.cosmos.schoolapp.data.builder.StudentBuilder;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Level {


  @Id @Generated private long levelID;

  @NotNull private String name;

  @NotNull Section section;




  private double SchoolFees;


  @Override
  public String toString() {
    return name;
  }
}
