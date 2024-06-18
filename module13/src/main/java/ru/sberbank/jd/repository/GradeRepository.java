package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, String> {

}
