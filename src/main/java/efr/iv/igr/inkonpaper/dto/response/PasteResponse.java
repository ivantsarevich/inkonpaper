package efr.iv.igr.inkonpaper.dto.response;

import efr.iv.igr.inkonpaper.model.PasteStatus;
import efr.iv.igr.inkonpaper.model.PasteVisibility;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Ответ с пастой")
public class PasteResponse {
    @Schema(description = "Заголовок", example = "Код сортировки")
    private String title;

    @Schema(description = "Паста", example = "a = a ^ b; b = a ^ b; a = a ^ b;")
    private String content;

    @Schema(description = "15-ый код для получения пасты", example = "ABCDEFGHIJKLMNO")
    private String code;

    @Schema(description = "Видимость пасты", example = "PUBLIC")
    private PasteVisibility visibility;

    @Schema(description = "Дата когда истечет паста", example = "2025-11-10T15:30:00")
    private LocalDateTime expiration;

    @Schema(description = "Статус пасты", example = "ACTIVE")
    private PasteStatus status;
}