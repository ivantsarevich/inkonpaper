package efr.iv.igr.inkonpaper.mapper;

import efr.iv.igr.inkonpaper.dto.request.PasteRequest;
import efr.iv.igr.inkonpaper.dto.response.PasteResponse;
import efr.iv.igr.inkonpaper.model.Paste;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PasteMapper {
    @Mapping(target = "status", expression = "java(efr.iv.igr.inkonpaper.model.PasteStatus.ACTIVE)")
    Paste toEntity(PasteRequest pasteRequest);

    PasteResponse toResponse(Paste paste);
}