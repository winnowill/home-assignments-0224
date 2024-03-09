package ru.sberbank.jd.lesson02.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


class NodImplTest {

    @Test
    void calculateSimple() {
        int nod = new NodImpl().calculate(1,0);
        Assertions.assertEquals( 1, nod );
        nod = new NodImpl().calculate(18,30);
        Assertions.assertEquals( 6, nod );
    }
    @Test
    void calculateMinus() {
        int nod = new NodImpl().calculate(-61,3);
        Assertions.assertEquals( 1, nod );
         nod = new NodImpl().calculate(-61,-3);
        Assertions.assertEquals( 1, nod );
    }
    @Test
    void calculateException() {

        Throwable exception = Assertions.assertThrows(UnsupportedOperationException.class,()->
                 new NodImpl().calculate(0,0)  );
        Assertions.assertEquals("Оба числа не могут быть равны нулю",
                                exception.getMessage());
    }
}