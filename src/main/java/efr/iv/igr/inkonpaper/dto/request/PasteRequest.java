package efr.iv.igr.inkonpaper.dto.request;

import efr.iv.igr.inkonpaper.model.PasteVisibility;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasteRequest {
    private String title;

    private String content;

    private PasteVisibility visibility;

    private LocalDateTime expiration;
}