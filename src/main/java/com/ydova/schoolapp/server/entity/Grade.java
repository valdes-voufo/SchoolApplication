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
public class Grade {

    @GeneratedValue
    @Id
    private long id;
    private long courseId;
    private int value;



}
