package ru.sberbank.jd.lesson10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import ru.sberbank.jd.lesson10.input.Catalog;
import ru.sberbank.jd.lesson10.output.Registry;



class SerializeTest {

    @Test
    void convertToFile() {
        ReadData data = new ReadData();
        try {
            Catalog catalog = data.readFile();
            TransformationData dataTnsform = new TransformationData();
            Registry registry = dataTnsform.convertToRegistry(catalog);
            Assertions.assertNotNull(registry);
            Serialize serialize = new Serialize();
            Assertions.assertTrue(serialize.convertToFile(registry));
        } catch (IOException e) {
            Assertions.assertEquals("", e.getMessage());
        }catch (ClassNotFoundException e) {
            Assertions.assertEquals("", e.getMessage());
        }
    }
}
