package ru.sberbank.jd.controller.output;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import ru.sberbank.jd.controller.input.GiftInput;
import ru.sberbank.jd.model.Gift;
import ru.sberbank.jd.service.GiftService;

/**
 * Controller for gifts.
 */
@RestController
@RequestMapping("/gifts")
@Slf4j
@RequiredArgsConstructor
public class GiftController {

    private final GiftService giftService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gift createGift(@RequestBody GiftInput giftInput) {
        Gift gift = giftService.createGift(giftInput);
        log.info("Gift created id = {}", gift.getId());
        return gift;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Gift> outAllGifts() {
        log.info("All gifts requested");
        return giftService.getAllGifts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gift outGift(@PathVariable("id") String id) {
        log.info("Gift requested by id = {}", id);
        Gift gift = giftService.getGiftById(id);
        if (gift == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Gift was not found");
        }
        return giftService.getGiftById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Gift removeGift(@PathVariable("id") String id) {
        log.info("Gift deleted id = {}", id);
        return giftService.removeGiftById(id);
    }
}
