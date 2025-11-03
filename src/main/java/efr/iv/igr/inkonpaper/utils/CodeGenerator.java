package efr.iv.igr.inkonpaper.utils;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Base64;

@Component
public class CodeGenerator {
    public String generateFromContentAndExpiration(String content, LocalDateTime expiration) {
        try {
            String input = content + expiration.toString();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            String code = Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
            return code.substring(0, 15);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating code", e);
        }
    }
}