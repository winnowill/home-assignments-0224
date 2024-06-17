package ru.sberbank.jd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee headDepartment;

    @OneToMany(mappedBy = "department_id", cascade  = CascadeType.ALL)
    private List<Employee> employees;

}
