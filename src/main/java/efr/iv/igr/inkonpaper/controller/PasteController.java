package efr.iv.igr.inkonpaper.controller;

import efr.iv.igr.inkonpaper.dto.request.PasteRequest;
import efr.iv.igr.inkonpaper.dto.response.PasteResponse;
import efr.iv.igr.inkonpaper.service.IPasteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pastes")
public class PasteController {
    @Autowired
    private IPasteService service;

    @Operation(
            summary = "Создание пасты",
            description = """
                    Пользователь отправляет пасту и получает код по которому можно найти данную пасту.
                    """
    )
    @PostMapping
    public PasteResponse createPaste(@RequestBody PasteRequest pasteRequest) {
        return service.createPaste(pasteRequest);
    }

    @Operation(
            summary = "Получение пасты",
            description = """
                    Пользователь вводит код и получает пасту этого кода.
                    """
    )
    @GetMapping("/{code}")
    public PasteResponse getPaste(@PathVariable String code) {
        return service.getPaste(code);
    }
}