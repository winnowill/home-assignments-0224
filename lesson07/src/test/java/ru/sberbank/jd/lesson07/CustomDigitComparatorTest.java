package ru.sberbank.jd.lesson07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class CustomDigitComparatorTest {

    @Test
    void compare() {
        CustomDigitComparator compareInt = new CustomDigitComparator();
        Assertions.assertEquals( 1, compareInt.compare(1, 2));
        Assertions.assertEquals( -1, compareInt.compare(2, 1));
        Assertions.assertEquals( 0, compareInt.compare(4, 4));
        Assertions.assertEquals( 0, compareInt.compare(1, 1));
    }
}