package ru.sberbank.jd.lesson10;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import ru.sberbank.jd.lesson10.output.Registry;

/**
 * Класс преобразования в json.
 */
public class Json {
    /**
     * Конвертация в json.
     *
     * @param registry Реестр
     * @throws IOException Ошибка чтения
     * @throws JsonProcessingException Ошибка преобразования
     */
    public boolean convertToJson(Registry registry) throws IOException, JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String fileName = "src/main/resources/output/artist_by_country.json";
        mapper.writeValue(new File(fileName), registry);
        return true;
    }
}
