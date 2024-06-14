package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;



/**
 * Класс для хранения данных о альбоме.
 */
@Setter
@Getter
public class Album implements Serializable {
    private static final long serialVersionUID = -926811698854726366L;
    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(isAttribute = true)
    private int year;

    public Album(String name, int year) {
        this.name = name;
        this.year = year;
    }
    /**
     *Вывод данных альбома на печать.
     *
     * @return Альбом
     */

    @Override
    public String toString() {
        return "Album{"
                + "name='" + name + '\''
                + ", year=" + year
                + '}';
    }
}
