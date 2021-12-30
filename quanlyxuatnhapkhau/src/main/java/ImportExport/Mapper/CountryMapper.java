package ImportExport.Mapper;

import ImportExport.DTO.CountryDTO;
import ImportExport.entity.CountryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CountryMapper {
    CountryEntity fromCountryDTO(CountryDTO countryDTO);
    CountryDTO fromCountryEntity(CountryEntity countryEntity);
}
