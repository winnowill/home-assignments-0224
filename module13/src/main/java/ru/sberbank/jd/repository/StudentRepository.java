package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, String>{
}
