package ImportExport.service.taxBracket;

import ImportExport.dto.taxBracket.TaxBracketCreateDto;
import ImportExport.dto.taxBracket.TaxBracketDetailDto;
import ImportExport.entity.TaxBracketEntity;

import java.util.Optional;
import java.util.UUID;

public interface TaxBracketService {
    TaxBracketDetailDto createTaxBracket(TaxBracketCreateDto taxBracketCreateDto);
    Optional<TaxBracketEntity> findById(UUID id);
}
