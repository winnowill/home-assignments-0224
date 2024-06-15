package ru.sberbank.jd.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    @OneToMany(mappedBy = "grade_id", cascade  = CascadeType.ALL)
    private List<Student> students;
}
