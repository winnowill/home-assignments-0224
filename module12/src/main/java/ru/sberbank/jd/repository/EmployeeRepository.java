package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Employee;

import java.util.List;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, String>{
    List<Employee> findEmployeeByNameAndSurname(String name, String surname);

}
