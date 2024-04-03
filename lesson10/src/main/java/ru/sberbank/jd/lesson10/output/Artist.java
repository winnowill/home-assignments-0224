package ru.sberbank.jd.lesson10.output;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс для хранения данных о исполнителе.
 */
@Setter
@Getter
public class Artist implements Serializable {
    private static final long serialVersionUID = -926811698854726366L;
    @JacksonXmlProperty(localName = "Name")
    private String name;

    @JacksonXmlElementWrapper(localName = "Albums")
    @JacksonXmlProperty(localName = "Album")
    private List<Album> albums = new ArrayList<>();

    public Artist(String name, List<Album> albums) {
        this.name = name;
        this.albums = albums;
    }
    /**
     *Вывод данных артиста на печать.
     *
     * @return Артист
     */

    @Override
    public String toString() {
        return "Artist{"
                + "name='" + name + '\''
                + ", albums=" + albums
                + '}';
    }
}
