package ImportExport.service.country;

import ImportExport.dto.country.CountryCreateDto;
import ImportExport.dto.country.CountryDetailDto;
import java.util.List;
import java.util.UUID;

public interface CountryService {
    CountryDetailDto createCountry(CountryCreateDto createDto);
    CountryDetailDto updateCountry(UUID id , CountryCreateDto countryCreateDto);
    List<CountryDetailDto> findAll();
    CountryDetailDto findById(UUID id);
    void deleteById( UUID id);


}
