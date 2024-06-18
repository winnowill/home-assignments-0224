package ru.sberbank.jd._dev;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.sberbank.jd.entity.Grade;
import ru.sberbank.jd.entity.Login;
import ru.sberbank.jd.entity.Student;
import ru.sberbank.jd.repository.GradeRepository;
import ru.sberbank.jd.repository.LoginRepository;
import ru.sberbank.jd.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Profile("test-data")
@Component
@AllArgsConstructor
@Slf4j

public class DataInit {
    private final GradeRepository gradeRepository;
    private final StudentRepository studentRepository;
    private final LoginRepository loginRepository;

    @PostConstruct
    @Transactional
    public void initData() {
        log.info("Start init data");
        Grade grade = new Grade();
        grade.setName("10B");
        gradeRepository.save(grade);
        Student student1 = new Student();
        student1.setName("John");
        student1.setGrade_id(grade);
        Student student2 = new Student();
        student2.setName("Jane");
        student2.setGrade_id(grade);
        studentRepository.save(student1);
        studentRepository.save(student2);
        Login login1 = new Login();
        login1.setUsername("test");
        login1.setPassword("test123");
        login1.setRole("USER");
        login1.setStudent(student1);
        loginRepository.save(login1);
        Login login2 = new Login();
        login2.setUsername("test2");
        login2.setPassword("test123");
        login2.setRole("ADMIN");
        login2.setStudent(student2);
        loginRepository.save(login2);
    }

}
