package ru.sberbank.jd.lesson10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import ru.sberbank.jd.lesson10.input.Catalog;
import ru.sberbank.jd.lesson10.input.Cd;

class ReadDataTest {

    @Test
    void readFile() {
        ReadData data = new ReadData();
        try {
            Catalog catalog = data.readFile();
            Assertions.assertEquals(26, catalog.getCds().size() );
            Assertions.assertEquals("Empire Burlesque", catalog.getCds().get(0).getTitle());
        } catch (IOException e) {
            Assertions.assertEquals("", e.getMessage());
        } catch (ClassNotFoundException e) {
            Assertions.assertEquals("", e.getMessage());
        }
    }

}