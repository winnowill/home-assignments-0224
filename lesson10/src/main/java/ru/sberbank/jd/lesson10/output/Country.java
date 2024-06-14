package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс для хранения данных об артистах в рамках страны.
 */
@Setter
@Getter
public class Country implements Serializable {
    private static final long serialVersionUID = -926811698854726366L;
    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Artist")
    private List<Artist> artists;

    public Country(String name, List<Artist> artists) {
        this.name = name;
        this.artists = artists;
    }
    /**
     *Вывод данных страны на печать.
     *
     * @return Страна
     */

    @Override
    public String toString() {
        return "Country{"
                + "name='" + name + '\''
                + ", artists=" + artists
                + '}';
    }
}
