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
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}
