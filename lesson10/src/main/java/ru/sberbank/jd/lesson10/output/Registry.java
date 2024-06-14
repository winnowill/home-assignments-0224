package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс для хранения данных по странам.
 */
@Setter
@Getter
@JacksonXmlRootElement(localName = "ArtistRegistry")
public class Registry implements Serializable {
    private static final long serialVersionUID = -926811698854726366L;
    @JacksonXmlProperty(isAttribute = true)
    private int countryCount;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "Country")
    private List<Country> countries = new ArrayList<>();

    /**
     * Конструктор реестра.
     *
     * @param countries Страны
     */
    public Registry(List<Country> countries) {
        this.countryCount = countries.size();
        this.countries = countries;
    }
    /**
     *Вывод данных реестра на печать.
     *
     * @return Реестр
     */

    @Override
    public String toString() {
        return "Registry{"
                + "countryCount" + countryCount
                + "countries=" + countries
                + '}';
    }
}
