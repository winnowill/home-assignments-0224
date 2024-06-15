package ru.sberbank.jd.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.sberbank.jd.controller.input.GiftInput;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Gift model.
 */
@Data
@AllArgsConstructor
@Builder
public class Gift {
    private String id;
    private String name;
    private String description;
    private final LocalDateTime createdDateTime;

    public static Gift of(GiftInput input) {
        return new GiftBuilder()
                .id(UUID.randomUUID().toString())
                .name(input.name())
                .description(input.description())
                .createdDateTime(LocalDateTime.now())
                .build();
    }
}
