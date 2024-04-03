package ru.sberbank.jd.lesson10;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Класс выгрузки в файл.
 */
public class Serialize {
    /**
     * Выгрузка в файл.
     *
     * @param registry Реестр
     * @throws IOException Ошибка ввода
     */
    public boolean convertToFile(Registry registry) throws IOException {
        String fileName = "src/main/resources/output/artist_by_country.serialized";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(registry);
        return true;
    }
}
