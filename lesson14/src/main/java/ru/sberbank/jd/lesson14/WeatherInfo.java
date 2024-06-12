package ru.sberbank.jd.lesson14;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

/**
 * Weather info.
 */
@Builder
public class WeatherInfo {
    @Getter
    private String city;

    /**
     * Short weather description.
     * Like 'sunny', 'clouds', 'raining', etc
     */
    private String shortDescription;

    /**
     * Weather description.
     * Like 'broken clouds', 'heavy raining', etc
     */
    private String description;

    /**
     * Temperature.
     */
    @Getter
    private double temperature;

    /**
     * Temperature that fells like.
     */
    private double feelsLikeTemperature;

    /**
     * Wind speed.
     */
    private double windSpeed;

    /**
     * Pressure.
     */
    private double pressure;

    /**
     * Expiry time of weather info.
     * If current time is above expiry time then current weather info is not actual!
     */
    private LocalDateTime expiryTime;

    /**
     * Weather info city.
     *
     * @return Weather info city description.
     */
    @Override
    public String toString() {
        return "WeatherInfo{"
                + "city='" + city + '\''
                + ", shortDescription='" + shortDescription + '\''
                + ", description='" + description + '\''
                + ", temperature=" + temperature
                + ", feelsLikeTemperature=" + feelsLikeTemperature
                + ", windSpeed=" + windSpeed
                + ", pressure=" + pressure
                + ", expiryTime=" + expiryTime
                + '}';
    }

    public Boolean isRelevanceTime() {

        return expiryTime.isAfter(LocalDateTime.now());
    }
}
