package efr.iv.igr.inkonpaper.dto.response;

import efr.iv.igr.inkonpaper.model.PasteStatus;
import efr.iv.igr.inkonpaper.model.PasteVisibility;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteResponse {
    private String title;

    private String content;

    private String code;

    private PasteVisibility visibility;

    private LocalDateTime expiration;

    private PasteStatus status;
}