package ru.sberbank.jd.model;

import java.util.UUID;

/**
 * Task1 data.
 */
public record Task(UUID id, String owner, String description) {

    public Task(String owner, String description) {

        this(UUID.randomUUID(), owner, description);
    }
}
