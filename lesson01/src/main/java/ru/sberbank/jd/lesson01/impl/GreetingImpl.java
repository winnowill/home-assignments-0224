package ru.sberbank.jd.lesson01.impl;

import java.util.ArrayList;
import java.util.Collection;
import ru.sberbank.jd.lesson01.Greeting;

/**
 * Реализация интерфейса для получения данных студентов для приветствия.
 */
public class GreetingImpl implements Greeting {

    /**
     * Получение имени.
     *
     * @return result
     */
    @Override
    public String getFirstName() {
        return "Людмила";
    }

    /**
     * Получение фамилии.
     *
     * @return result
     */

    @Override
    public String getLastName() {
        return "Елфимова";
    }

    /**
     * Получение года рождения.
     *
     * @return result
     */
    @Override
    public int getBirthYear() {
        return 1985;
    }

    /**
     * Получение набора хобби.
     *
     * @return result
     */
    @Override
    public Collection<String> getHobbies() {
        ArrayList<String>  hobbies = new ArrayList<>();
        hobbies.add("Шитье одежды");
        hobbies.add("Машинная вышивка");
        hobbies.add("Чтение");
        return hobbies;
    }

    /**
     * Получение имени репозитория.
     *
     * @return result
     */
    @Override
    public String getRepoUrl() {

        return "https://github.com/winnowill/home-assignments-0224";
    }

    /**
     *  Получение телефона.
     *
     * @return result
     */
    @Override
    public String getPhone() {
        return "89176488912";
    }

    /**
     * Получение набора ожиданий от курса.
     *
     * @return result
     */
    @Override
    public Collection<String> getCourseExpectations() {
        ArrayList<String> courseExpect = new ArrayList<>();
        courseExpect.add("Научиться основам Java");
        courseExpect.add("Перестроить представление о программировании при переходе с ABAP");
        courseExpect.add("Получить представление о современных подходах к разработке");
        return courseExpect;
    }
}
