package ru.sberbank.jd.lesson04;

import lombok.AllArgsConstructor;


/**
 * Класс формирования ответа на введенные команды.
 */
@AllArgsConstructor
public class OutputResult {
    private String message;
    /**
     * Формирование ответа.
     *
     * @return Сообщение
     */

    @Override
    public String toString() {
        return "wc: " + message;
    }
}

