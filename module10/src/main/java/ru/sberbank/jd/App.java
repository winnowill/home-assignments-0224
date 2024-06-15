package ru.sberbank.jd;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sberbank.jd.model.GetResponse;
import ru.sberbank.jd.service.MyRestService;

/**
 * Главная программа Spring приложения.
 */
@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class App {

MyRestService restService;

    public static void main( String[] args ) {

        SpringApplication.run(App.class,args);
    }

    @PostConstruct
    public void execute() {

        if (restService == null) {
            return;
        }

        GetResponse getResponse = restService.get();
        if (getResponse == null) {
            return;
        }
        System.out.println("HTTP kod = " + getResponse.getStatusCode());
        System.out.println("Response JSON = " + getResponse.getResult());
    }
}
