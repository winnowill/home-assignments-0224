package ru.sberbank.jd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.jd.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
    Login findLoginByUsername(String username);
}
