package efr.iv.igr.inkonpaper.service;

import efr.iv.igr.inkonpaper.dto.request.PasteRequest;
import efr.iv.igr.inkonpaper.dto.response.PasteResponse;

public interface IPasteService {
    PasteResponse createPaste(PasteRequest pasteRequest);

    PasteResponse getPaste(String code);
}