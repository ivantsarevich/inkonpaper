package efr.iv.igr.inkonpaper.utils;

import efr.iv.igr.inkonpaper.dto.request.PasteRequest;
import efr.iv.igr.inkonpaper.model.PasteVisibility;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PasteGenerator {
    public PasteRequest pasteRequestGenerate() {
        return PasteRequest.builder()
                .title("title")
                .content("content")
                .visibility(PasteVisibility.PUBLIC)
                .expiration(LocalDateTime.of(2025, 10, 9, 2, 2, 2))
                .build();
    }
}
