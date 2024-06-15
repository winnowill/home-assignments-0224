package ru.sberbank.jd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Role {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;
        private String name;

        @ManyToOne(fetch = FetchType.EAGER)
        private Project project;

        @ManyToMany(mappedBy = "roles")
        private Set<Employee> employees = new HashSet<>();



}
