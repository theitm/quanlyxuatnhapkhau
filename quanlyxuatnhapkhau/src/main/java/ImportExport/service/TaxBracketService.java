package ImportExport.service;

import ImportExport.entity.TaxBracketEntity;

import java.util.Optional;
import java.util.UUID;

public interface TaxBracketService {
    Optional<TaxBracketEntity>findById(UUID id);
}
