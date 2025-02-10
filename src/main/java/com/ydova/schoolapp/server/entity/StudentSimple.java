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

public class StudentSimple {
    @Id
    @GeneratedValue
    private long id;
    private String lastname;
    private String firstname;

    @Override
    public String toString() {
        return lastname + " " + firstname;
    }
}
