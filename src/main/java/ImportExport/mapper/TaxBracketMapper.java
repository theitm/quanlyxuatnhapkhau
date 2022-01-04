package ImportExport.mapper;

import ImportExport.dto.taxBracket.TaxBracketCreateDto;
import ImportExport.dto.taxBracket.TaxBracketDetailDto;
import ImportExport.entity.TaxBracketEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TaxBracketMapper {
    TaxBracketEntity fromTaxBracketCreateDto(TaxBracketCreateDto taxBracketCreateDto);
    TaxBracketDetailDto fromEntityToDto (TaxBracketEntity taxBracketEntity);
}
