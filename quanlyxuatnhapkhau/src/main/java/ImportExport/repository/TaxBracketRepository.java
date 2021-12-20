package ImportExport.repository;

import ImportExport.entity.TaxBracketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TaxBracketRepository extends JpaRepository<TaxBracketEntity, UUID> {
    void deleteById(UUID id);
    Optional<TaxBracketEntity> findById(UUID id);

}
