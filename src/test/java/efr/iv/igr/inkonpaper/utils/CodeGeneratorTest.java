package efr.iv.igr.inkonpaper.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CodeGeneratorTest {
    @Test
    public void testCodeGenerator() {
        CodeGenerator codeGenerator = new CodeGenerator();
        String content = "content";
        LocalDateTime expiration = LocalDateTime.of(2025, 10, 9, 2, 2, 2);
        String code = codeGenerator.generateFromContentAndExpiration(content, expiration);
        Assertions.assertNotNull(code);
        Assertions.assertEquals("By3Zb__UxSemFDo", code);
    }
}
