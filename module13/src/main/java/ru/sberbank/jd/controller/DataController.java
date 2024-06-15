package ru.sberbank.jd.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.jd.entity.Grade;
import ru.sberbank.jd.entity.Login;
import ru.sberbank.jd.entity.Student;
import ru.sberbank.jd.repository.StudentRepository;
import ru.sberbank.jd.repository.GradeRepository;
import ru.sberbank.jd.repository.LoginRepository;
import java.util.List;

@RestController
@Slf4j
public class DataController {
private StudentRepository studentRepository;
private GradeRepository gradeRepository;
private LoginRepository loginRepository;

    @GetMapping("/students")
    public String getStudents() {

     List<Student> students = studentRepository.findAll();
        return students.toString();
    }

    @PreAuthorize("hasRole('ADMIN') or hasPermission()")
    @PostMapping("/insertStudent")
    public String isertStudent() {
        log.info("Start init data");
        Grade grade = new Grade();
        grade.setName("10B");
        Student student1 = new Student();
        student1.setName("John");
        student1.setGrade_id(grade);
        studentRepository.save(student1);
        Login login1 = new Login();
        login1.setUsername("test2");
        login1.setPassword("test123");
        login1.setRole("USER");
        login1.setStudent(student1);
        loginRepository.save(login1);
        return "Create:" + student1.toString();
    }

}