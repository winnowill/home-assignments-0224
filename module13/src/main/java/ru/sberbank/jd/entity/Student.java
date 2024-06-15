package ru.sberbank.jd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String surname;
    @ManyToOne(fetch  = FetchType.EAGER)
    @JoinColumn(name = "grade_id")
    private Grade grade_id;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grade_id=" + grade_id +
                '}' ;
    }
}

