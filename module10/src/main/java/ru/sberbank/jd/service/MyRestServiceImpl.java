package ru.sberbank.jd.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.model.GetResponse;

/**
 * Основная реализация методов GET профиля PROM.
 */
@Slf4j
@AllArgsConstructor
public class MyRestServiceImpl implements MyRestService{

    private RestTemplate restTemplate;
    private String url;

    @Override
    public GetResponse get() {

        log.info("Вызов метода MyRestServiceImpl.GET");
        ResponseEntity<String> response;

        try {
            response = restTemplate.getForEntity(url, String.class);
        } catch (RestClientException e) {
            log.error("Ошибка вызова сервиса {} на методе RestTemplate.getForEntity",url);
            return null;
        }

        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            log.error("Ошибка вызова сервиса, не найден");
            return null;
        } else if (response.getStatusCode() != HttpStatus.OK) {
            log.error("Ошибка вызова сервиса");
            return null;
        }

        return new GetResponse(response.getStatusCode().value(),response.getBody());
    }
}
