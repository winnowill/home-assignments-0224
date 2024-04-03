package ru.sberbank.jd.lesson10;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import ru.sberbank.jd.lesson10.input.Catalog;

/**
 * Класс чтения xml.
 */
public class ReadData {
    /**
     * Метод меревода xml в объект.
     *
     * @return Сситанный каталог
     * @throws IOException            Ошибка ввода
     * @throws ClassNotFoundException Ошибка чтения
     */
    public Catalog readFile() throws IOException, ClassNotFoundException {
        File file = new File("src/main/resources/input/cd_catalog.xml");
        XmlMapper xmlMapper = new XmlMapper();
        Catalog catalog = xmlMapper.readValue(file, Catalog.class);
        return catalog;
    }
}
