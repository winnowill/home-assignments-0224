package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
}
