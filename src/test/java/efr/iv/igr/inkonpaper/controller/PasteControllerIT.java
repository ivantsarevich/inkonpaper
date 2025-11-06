package efr.iv.igr.inkonpaper.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import efr.iv.igr.inkonpaper.dto.request.PasteRequest;
import efr.iv.igr.inkonpaper.utils.PasteGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
public class PasteControllerIT {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:16");

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PasteGenerator pasteGenerator;

    @Autowired
    ObjectMapper objectMapper;

    PasteRequest pasteRequest;

    @BeforeEach
    public void setup() {
        pasteRequest = pasteGenerator.pasteRequestGenerate();
    }

    @Test
    public void givenPasteRequest_whenCreatePaste_thenReturnSuccess() throws Exception {
        this.mockMvc.perform(post("/api/v1/pastes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pasteRequest)))
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.code").isNotEmpty(),
                        jsonPath("$.code").value("By3Zb__UxSemFDo")
                );
    }
}
