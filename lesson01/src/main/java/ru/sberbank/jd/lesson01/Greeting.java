package ru.sberbank.jd.lesson01;

import java.util.Collection;

/**
 * Интерфейс для получения данных студентов для приветствия.
 */
public interface Greeting {

    /**
     * Получение имени.
     */
    String getFirstName();

    /**
     * Получение фамилии.
     */
    String getLastName();

    /**
     * Получение года рождения.
     */
    int getBirthYear();

    /**
     * Получение набора хобби.
     */
    Collection<String> getHobbies();

    /**
     * Получение имени репозитория.
     */
    String getRepoUrl();

    /**
     * Получение телефона.
     */
    String getPhone();

    /**
     * Получение набора ожиданий от курса.
     */
    Collection<String> getCourseExpectations();

}
