package ru.sberbank.jd.lesson02.impl;

import ru.sberbank.jd.lesson02.Nod;

/**
 * Реализация интерфейса для определения наибольшего общего делителя двух целых чисел.
 */
public class NodImpl implements Nod {
    /**
     * Вычисляет наибольший общий делитель двух целых чисел.
     *
     * @param first  первое число
     * @param second второе число
     * @return наибольший общий делитель
     */
    @Override
    public int calculate(int first, int second) {
        if (first == 0 && second == 0) {
            throw new UnsupportedOperationException("Оба числа не могут быть равны нулю");
        }
        int firstNum = Math.abs(first);
        int secondNum = Math.abs(second);
        while (firstNum != 0 && secondNum != 0) {
            if (firstNum > secondNum) {
                firstNum = firstNum % secondNum;
            } else {
                secondNum = secondNum % firstNum;
            }
        }
        return firstNum + secondNum;
    }
}
