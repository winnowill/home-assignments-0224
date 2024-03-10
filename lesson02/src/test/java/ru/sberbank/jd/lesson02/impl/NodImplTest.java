package ru.sberbank.jd.lesson02.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class NodImplTest {

    NodImpl nodImpl = new NodImpl();

    @Test
    void calculateSimple() {
        int nod = nodImpl.calculate(1, 0);
        Assertions.assertEquals(1, nod);
        nod = nodImpl.calculate(18, 30);
        Assertions.assertEquals(6, nod);
        Assertions.assertEquals(12, nodImpl.calculate(24, 36));
    }

    @Test
    void calculateMinus() {
        int nod = nodImpl.calculate(-61, 3);
        Assertions.assertEquals(1, nod);
        nod = nodImpl.calculate(-61, -3);
        Assertions.assertEquals(1, nod);
    }

    @Test
    void calculateException() {
        Throwable exception = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> nodImpl.calculate(0, 0));
        Assertions.assertEquals("Оба числа не могут быть равны нулю",
                exception.getMessage());
    }
}