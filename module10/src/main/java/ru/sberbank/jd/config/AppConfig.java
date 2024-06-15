package ru.sberbank.jd.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import ru.sberbank.jd.service.MyRestService;
import ru.sberbank.jd.service.MyRestServiceImpl;
import ru.sberbank.jd.service.MyRestServiceStubImpl;

/**
 * Application configuration class
 */
@Slf4j
@Configuration
public class AppConfig {

    @Value("${app.param1}")
    private String param1;


    @Value("${app.url}")
    private String url;

    @Profile("prom")
    @Bean
    public RestTemplate restTemplate(){
        log.info("Create bean RestTemplate");
        log.info("url = {}", url);
        return new RestTemplate();
    }

    @Profile("prom")
    @Bean
    public MyRestService myRestServiceImpl(){

        log.info("Create bean MyRestServiceImpl, profile = {}", param1);
        return new MyRestServiceImpl(restTemplate(), url);
    }
    @Profile("dev")
    @Bean
    public MyRestService myRestServiceStubImpl(){

        log.info("Create bean myRestServiceStubImpl, profile = {}", param1);
        return new MyRestServiceStubImpl();
    }
}