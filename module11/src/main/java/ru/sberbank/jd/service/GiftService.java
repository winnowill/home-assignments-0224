package ru.sberbank.jd.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import ru.sberbank.jd.controller.input.GiftInput;
import ru.sberbank.jd.model.Gift;
import ru.sberbank.jd.repository.GiftRepository;

/**
 * Service for working with gifts.
 */

@Service
@RequiredArgsConstructor
public class  GiftService {

    private final GiftRepository giftRepository;

    public Gift createGift(@NonNull GiftInput taskInput) {
        Gift gift = Gift.of(taskInput);
        giftRepository.save(gift);
        return gift;
    }

    public List<Gift> getAllGifts() {
        return giftRepository.getGifts();
    }

    public Gift getGiftById(String id) {
        return giftRepository.getGiftById(id);
    }

    public Gift removeGiftById(String id) {
        return giftRepository.removeGiftById(id);
    }
}
