package ru.sberbank.jd.lesson12.model;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Класс, отражающий структуру хранимых в таблице полей.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    /*
     * Первичный ключ.
     *
     * Рекомендуется генерировать его только внутри StudentsRepositoryCRUD.create(),
     * иными словами до момента пока объект не будет сохранен в БД, он не должен
     * иметь значение id.
     */
    private UUID id;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private boolean isGraduated;

    /**
     *Вывод данных студента на печать.
     *
     * @return Студент
     */
    @Override
    public String toString() {
        return "Student{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", birthDate=" + birthDate
                + ", isGraduated=" + isGraduated
                + '}';
    }
}
