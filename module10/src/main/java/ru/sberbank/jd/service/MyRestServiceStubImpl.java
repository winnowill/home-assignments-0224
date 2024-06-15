package ru.sberbank.jd.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.sberbank.jd.model.GetResponse;

/**
 * Реализация - заглушка для профиля DEV.
 */
@Slf4j
@AllArgsConstructor
public class MyRestServiceStubImpl implements MyRestService{

    @Override
    public GetResponse get() {
        log.info("Вызов метода MyRestServiceStubImpl.GET");
        return new GetResponse(999, "for DEV test");
    }
}