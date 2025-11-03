package efr.iv.igr.inkonpaper.repository;

import efr.iv.igr.inkonpaper.model.Paste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasteRepository extends JpaRepository<Paste, Long> {
    Optional<Paste> findByCode(String code);
}