package efr.iv.igr.inkonpaper.controller;

import efr.iv.igr.inkonpaper.dto.request.PasteRequest;
import efr.iv.igr.inkonpaper.dto.response.PasteResponse;
import efr.iv.igr.inkonpaper.service.IPasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pastes")
public class PasteController {
    @Autowired
    private IPasteService service;

    @PostMapping
    public PasteResponse createPaste(@RequestBody PasteRequest pasteRequest) {
        return service.createPaste(pasteRequest);
    }

    @GetMapping("/{code}")
    public PasteResponse getPaste(@PathVariable String code) {
        return service.getPaste(code);
    }
}