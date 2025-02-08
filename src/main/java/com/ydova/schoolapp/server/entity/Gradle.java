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
public class Gradle {

    @GeneratedValue
    @Id
    public long id;
    public long courseId;
    public int value;


}
