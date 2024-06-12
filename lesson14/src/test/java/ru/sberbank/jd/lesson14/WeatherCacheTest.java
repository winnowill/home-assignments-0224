package ru.sberbank.jd.lesson14;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;

/**
 *  Run the tests
 */
class WeatherCacheTest {

    @Test
    public void checkCity() {
        WeatherProvider mockWeatherProvider = Mockito.mock(WeatherProvider.class);
        Mockito.when(mockWeatherProvider.get("Volgograd")).thenReturn(
                WeatherInfo.builder()
                        .city("Volgograd")
                        .shortDescription("test_shortDescription_Volgograd")
                        .description("test_Description_Volgograd")
                        .temperature(15.0)
                        .feelsLikeTemperature(10.2)
                        .windSpeed(15.1)
                        .pressure(410.5)
                        .expiryTime(LocalDateTime.now().plusMinutes(5))
                        .build()
        );
        WeatherCache weatherCache = new WeatherCache(mockWeatherProvider);
        Assertions.assertNotNull(weatherCache);
        Assertions.assertEquals("Volgograd", weatherCache.getWeatherInfo("Volgograd").getCity());
    }

    @Test
    public void checkWeatherInfo() {
        WeatherProvider mockWeatherProvider = Mockito.mock(WeatherProvider.class);
        Mockito.when(mockWeatherProvider.get("Volgograd")).thenReturn(
                WeatherInfo.builder()
                        .city("Volgograd")
                        .shortDescription("test_shortDescription_Volgograd")
                        .description("test_Description_Volgograd")
                        .temperature(15.0)
                        .feelsLikeTemperature(10.2)
                        .windSpeed(15.1)
                        .pressure(410.5)
                        .expiryTime(LocalDateTime.now().plusMinutes(5))
                        .build()
        );
        WeatherCache weatherCache = new WeatherCache(mockWeatherProvider);
        Assertions.assertNotNull(weatherCache);

        double temperatureVolgograd= weatherCache.getWeatherInfo("Volgograd").getTemperature();
        Assertions.assertEquals("15.0", String.valueOf(temperatureVolgograd));
        Assertions.assertTrue(weatherCache.getWeatherInfo("Volgograd").isRelevanceTime());
    }

    @Test
    public void checkWeatherInfoAfterRelevanceTime() {

        WeatherProvider mockWeatherProvider = Mockito.mock(WeatherProvider.class);

        WeatherCache weatherCache = new WeatherCache(mockWeatherProvider);
        Assertions.assertNotNull(weatherCache);
        // проверяем, что город Москва загружен в буфер с температурой 11.5
        Mockito.when(mockWeatherProvider.get("Moscow")).thenReturn(
                WeatherInfo.builder()
                        .city("Moscow")
                        .shortDescription("test_shortDescription_Moscow")
                        .description("test_Description_Moscow")
                        .temperature(11.5)
                        .feelsLikeTemperature(9.3)
                        .windSpeed(7.9)
                        .pressure(190.5)
                        .expiryTime(LocalDateTime.now())
                        .build()
        );
        Assertions.assertEquals("Moscow",weatherCache.getWeatherInfo("Moscow").getCity());
        Assertions.assertEquals("11.5",String.valueOf(weatherCache.getWeatherInfo("Moscow").getTemperature()));
//       пауза
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // проверяем, что город Москва загружен в буфер с температурой 19.5
        Mockito.when(mockWeatherProvider.get("Moscow")).thenReturn(
                WeatherInfo.builder()
                        .city("Moscow")
                        .shortDescription("test_shortDescription_Moscow2")
                        .description("test_Description_Moscow2")
                        .temperature(19.5)
                        .feelsLikeTemperature(29.3)
                        .windSpeed(17.9)
                        .pressure(191.5)
                        .expiryTime(LocalDateTime.now().plusMinutes(5))
                        .build());

        double temperatureMoscow = weatherCache.getWeatherInfo("Moscow").getTemperature();

        Assertions.assertEquals("19.5",String.valueOf(temperatureMoscow));
    }

    @Test
    public void simpleTest() {
//
        WeatherProvider mockWeatherProvider = Mockito.mock(WeatherProvider.class);

        WeatherCache weatherCache = new WeatherCache(mockWeatherProvider);
        Assertions.assertNotNull(weatherCache);

        Mockito.when(mockWeatherProvider.get("qwerty")).thenReturn( null);
        Assertions.assertNull(weatherCache.getWeatherInfo("qwerty"));
    }
}