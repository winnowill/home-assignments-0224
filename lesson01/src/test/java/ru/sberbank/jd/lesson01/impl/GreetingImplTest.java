package ru.sberbank.jd.lesson01.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

class GreetingImplTest {

    @Test
    void getFirstName() {
        String expected = "Людмила";
        String actual = new GreetingImpl().getFirstName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getLastName() {
        String expected = "Елфимова";
        String actual = new GreetingImpl().getLastName();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getBirthYear() {
        int expected = 1985;
        int actual = new GreetingImpl().getBirthYear();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getHobbies() {
        Collection<String> expected = new ArrayList<>();
        expected.add("Шитье одежды");
        expected.add("Машинная вышивка");
        expected.add("Чтение");
        Collection<String> actual = new GreetingImpl().getHobbies();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getRepoUrl() {
        String expected = "https://github.com/winnowill/home-assignments-0224";
        String actual = new GreetingImpl().getRepoUrl();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getPhone() {
        String expected = "89176488912";
        String actual = new GreetingImpl().getPhone();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void getCourseExpectations() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Научиться основам Java");
        expected.add("Перестроить представление о программировании при переходе с ABAP");
        expected.add("Получить представление о современных подходах к разработке");
        Collection<String> actual = new GreetingImpl().getCourseExpectations();
        Assertions.assertEquals(expected, actual);
    }
}