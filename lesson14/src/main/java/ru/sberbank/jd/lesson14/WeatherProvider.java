package ru.sberbank.jd.lesson14;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Weather provider.
 */
public class WeatherProvider {

    private static final String URL1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private static final String URL2 = "&units=metric&appid=0eff1e50e0daf8e6673ab4e5dfcbcd41";
    private final RestTemplate restTemplate;

    /**
     * Constructor.
     */
    public WeatherProvider() {
        this.restTemplate = new RestTemplate();
    }

    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    public WeatherInfo get(String city) {
        String url = URL1 + city + URL2;

        ResponseEntity<String> response;
        try {
            response = restTemplate.getForEntity(url, String.class);
        } catch (RestClientException e) {
            return null;
        }

        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return null;
        } else if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Ошибка вызова сервиса");
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Ошибка разбора данных");
        }

        return WeatherInfo.builder()
                .city(jsonNode.get("name").toString())
                .shortDescription(jsonNode.get("weather").get(0).get("main").toString())
                .description(jsonNode.get("weather").get(0).get("description").toString())
                .temperature(jsonNode.get("main").get("temp").asDouble())
                .feelsLikeTemperature(jsonNode.get("main").get("feels_like").asDouble())
                .windSpeed(jsonNode.get("wind").get("speed").asDouble())
                .pressure(jsonNode.get("main").get("pressure").asDouble())
                .expiryTime(LocalDateTime.now().plusMinutes(5))
                .build();
    }
}
