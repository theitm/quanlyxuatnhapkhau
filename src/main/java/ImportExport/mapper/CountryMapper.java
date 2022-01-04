package ImportExport.mapper;

import ImportExport.dto.country.CountryCreateDto;
import ImportExport.dto.country.CountryDetailDto;
import ImportExport.entity.CountryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CountryMapper {
    CountryEntity fromCountryCreateDto(CountryCreateDto countryCreateDto);
    CountryDetailDto fromEntityToDetailDto(CountryEntity countryEntity);

}
