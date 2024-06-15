package ru.sberbank.jd.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  Information about response.
 */

@Getter
@AllArgsConstructor
public class GetResponse {
    private final int statusCode;
    private final String result;
}
