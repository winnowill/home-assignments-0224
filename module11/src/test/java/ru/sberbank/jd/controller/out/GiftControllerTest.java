package ru.sberbank.jd.controller.out;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import ru.sberbank.jd.model.Gift;
import ru.sberbank.jd.service.GiftService;


@SpringBootTest
@AutoConfigureMockMvc
class GiftControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    @MockBean
    private GiftService giftService;

    @Test
    public void createGift_post_200() throws Exception {
        Gift mockGift = Gift.builder()
                .id("123456")
                .name("gift")
                .description("some description")
                .createdDateTime(LocalDateTime.now())
                .build();
        Mockito.when(giftService.createGift(ArgumentMatchers.any())).thenReturn(mockGift);
        mockMvc.perform(post("/gifts").content("{\n" +
                "\t\"name\":\"gift\",\n" +
                "\t\"description\":\"some description\"\n" +
                "}").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void notFound_error_404() throws Exception {
        mockMvc.perform(get("/gifts/some-wrong-id")).andExpect(status().isNotFound());
    }

    @Test
    public void outAllGifts_get_200() throws Exception {
        List<Gift> mockGifts = new ArrayList<>();
        mockGifts.add(Gift.builder()
                .id("123456")
                .name("gift")
                .description("some description")
                .createdDateTime(LocalDateTime.now())
                .build());
        Mockito.when(giftService.getAllGifts()).thenReturn(mockGifts);
        mockMvc.perform(get("/gifts/all").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    public void outGift_get_200() throws Exception {
        Gift mockGift = Gift.builder()
                .id("123456")
                .name("gift")
                .description("some description")
                .createdDateTime(LocalDateTime.now())
                .build();
        Mockito.when(giftService.getGiftById(ArgumentMatchers.anyString())).thenReturn(mockGift);
        mockMvc.perform(get("/gifts/some_id").accept(MediaType.APPLICATION_JSON));
    }

    @Test
    void removeGift_delete_200() throws Exception {
        Gift mockGift = Gift.builder()
                .id("123456")
                .name("gift")
                .description("some description")
                .createdDateTime(LocalDateTime.now())
                .build();
        Mockito.when(giftService.removeGiftById(ArgumentMatchers.anyString())).thenReturn(mockGift);
        mockMvc.perform(delete("/gifts/some_id").accept(MediaType.APPLICATION_JSON));
    }
}
