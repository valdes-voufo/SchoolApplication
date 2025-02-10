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
public class School {
    @Id @GeneratedValue
    private Long id;

    private String schoolName;
    private  String schoolAddress;
    private  String BP;
    private  String telephone;
    private  String webseiteURL;



}
