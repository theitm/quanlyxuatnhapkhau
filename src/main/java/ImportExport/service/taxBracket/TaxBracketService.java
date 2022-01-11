package ImportExport.service.taxBracket;

import ImportExport.dto.taxBracket.TaxBracketCreateDto;
import ImportExport.dto.taxBracket.TaxBracketDetailDto;
import java.util.List;
import java.util.UUID;

public interface TaxBracketService {
    TaxBracketDetailDto createTaxBracket(TaxBracketCreateDto taxBracketCreateDto);
    TaxBracketDetailDto findById(UUID id);
    List<TaxBracketDetailDto> findAll();
    TaxBracketDetailDto updateTaxBracket (UUID id, TaxBracketCreateDto taxBracketCreateDto);
    void deleteById(UUID id);
}
