package efr.iv.igr.inkonpaper.service.impl;

import efr.iv.igr.inkonpaper.dto.request.PasteRequest;
import efr.iv.igr.inkonpaper.dto.response.PasteResponse;
import efr.iv.igr.inkonpaper.mapper.PasteMapper;
import efr.iv.igr.inkonpaper.model.Paste;
import efr.iv.igr.inkonpaper.repository.PasteRepository;
import efr.iv.igr.inkonpaper.service.IPasteService;
import efr.iv.igr.inkonpaper.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PasteServiceImpl implements IPasteService {
    @Autowired
    private PasteRepository repository;

    @Autowired
    private PasteMapper mapper;

    @Autowired
    private CodeGenerator generator;

    @Override
    public PasteResponse createPaste(PasteRequest pasteRequest) {
        Paste paste = mapper.toEntity(pasteRequest);
        String content = paste.getContent();
        LocalDateTime expiration = paste.getExpiration();
        paste.setCode(generator.generateFromContentAndExpiration(content, expiration));
        Paste save = repository.save(paste);
        return mapper.toResponse(save);
    }

    @Override
    public PasteResponse getPaste(String code) {
        Paste paste = repository.findByCode(code).orElseThrow(() -> new RuntimeException("Paste not found"));
        return mapper.toResponse(paste);
    }
}