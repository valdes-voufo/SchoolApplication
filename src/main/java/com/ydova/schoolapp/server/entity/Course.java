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

public class Course {

   private String name;

    @Id
    @GeneratedValue
   private Long courseId;

    @Override
    public String toString() {
        return name;
    }
}
