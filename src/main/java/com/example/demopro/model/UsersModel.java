package com.example.demopro.model;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "users_table")

public class UsersModel {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String login;
    private String password;
    private String email;


    @Override
    public String toString() {
        return "UsersModel{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
