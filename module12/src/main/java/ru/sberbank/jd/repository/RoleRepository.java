package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
