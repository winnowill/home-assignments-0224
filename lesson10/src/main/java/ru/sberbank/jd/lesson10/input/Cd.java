package ru.sberbank.jd.lesson10.input;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;


/**
 * Класс для хранения данных о диске.
 */
@Setter
@Getter
@JacksonXmlRootElement(localName = "CD")
public class Cd  {

    @JacksonXmlProperty(localName = "TITLE")
    private String title;
    @JacksonXmlProperty(localName = "ARTIST")
    private String artist;
    @JacksonXmlProperty(localName = "COUNTRY")
    private String country;
    @JacksonXmlProperty(localName = "COMPANY")
    private String company;
    @JacksonXmlProperty(localName = "PRICE")
    private double price;
    @JacksonXmlProperty(localName = "YEAR")
    private int year;
    /**
     *Вывод данных диска на печать.
     *
     * @return Диск
     */

    @Override
    public String toString() {
        return "Cd{"
                + "title='" + title + '\''
                + ", artist='" + artist + '\''
                + ", country='" + country + '\''
                + ", company='" + company + '\''
                + ", price=" + price
                + ", year=" + year
                + '}' + '\n';
    }
}
