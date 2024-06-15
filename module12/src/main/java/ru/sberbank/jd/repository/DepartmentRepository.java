package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
