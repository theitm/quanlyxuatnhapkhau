package ImportExport.service.country;

import ImportExport.dto.country.CountryCreateDto;
import ImportExport.dto.country.CountryDetailDto;
import ImportExport.entity.CountryEntity;
import java.util.Optional;
import java.util.UUID;

public interface CountryService {
    CountryDetailDto createCountry(CountryCreateDto createDto);
    Optional<CountryEntity> findById(UUID id);

}
