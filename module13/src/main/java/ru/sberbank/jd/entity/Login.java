package ru.sberbank.jd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String username;
    private String password;
    private String role;
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;

}

