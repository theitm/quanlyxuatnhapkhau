package ImportExport.Mapper;

import ImportExport.DTO.TaxBracketDTO;
import ImportExport.entity.TaxBracketEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TaxBracketMapper {
    TaxBracketEntity fromTaxBracketDTO(TaxBracketDTO taxBracketDTO);
    TaxBracketDTO fromTaxBracketEntity(TaxBracketEntity taxBracketEntity);
}
