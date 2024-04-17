package ru.sberbank.jd.lesson12.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.sberbank.jd.lesson12.model.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.UUID;

class StudentsRepositoryCrudImplTest {

    @Test
    void create() {
        StudentsRepositoryCrudImpl repositoryCrud = new StudentsRepositoryCrudImpl();
        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");
        student.setBirthDate(new Date(102, 1, 01));
        student.setGraduated(false);
        UUID id = repositoryCrud.create(student);
        Student studentBD = repositoryCrud.selectById(id);
        Assertions.assertEquals(student.getFirstName(), studentBD.getFirstName());
        student.setFirstName("Alex");
        repositoryCrud.create(student);
        Assertions.assertNotEquals(studentBD.getFirstName(), student.getFirstName());
        List<UUID> listId = new ArrayList<>();
        listId.add(id);
        repositoryCrud.remove(listId);
        List<Student> students = repositoryCrud.selectAll();
        Assertions.assertEquals(0, students.size());

    }
}