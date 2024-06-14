package ru.sberbank.jd.lesson10.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
/**
 * Класс для хранения данных каталога.
 */

@Setter
@Getter
@JacksonXmlRootElement(localName = "CATALOG")
public class Catalog {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "CD")
    private List<Cd> cds;

    /**
     *Вывод данных каталога на печать.
     *
     * @return Каталог
     */
    @Override
    public String toString() {
        return "Catalog{"
                + "cds=" + cds
                + '}';
    }
}
