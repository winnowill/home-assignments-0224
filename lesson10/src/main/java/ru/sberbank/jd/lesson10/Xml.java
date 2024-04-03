package ru.sberbank.jd.lesson10;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Класс преобразования в XML.
 */
public class Xml {
    /**
     * Преобразованиев в XML.
     *
     * @param registry Реестр
     * @throws IOException Ошибка ввода
     * @throws JsonProcessingException Ошибка записи
     */
    public boolean convertToXml(Registry registry) throws IOException, JsonProcessingException {
        String fileName = "src/main/resources/output/artist_by_country.xml";
        XmlMapper xmlMapperOut = new XmlMapper();
        xmlMapperOut.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapperOut.writeValue(new File(fileName), registry);
        return true;
    }
}
