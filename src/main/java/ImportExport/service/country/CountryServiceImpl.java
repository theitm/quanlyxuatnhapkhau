package ImportExport.service.country;

import ImportExport.dto.country.CountryCreateDto;
import ImportExport.dto.country.CountryDetailDto;
import ImportExport.entity.CountryEntity;
import ImportExport.mapper.CountryMapper;
import ImportExport.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
    public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }
    public Optional<CountryEntity> findById(UUID id) {
        return countryRepository.findById(id);
    }
    public CountryDetailDto createCountry(CountryCreateDto countryCreateDto) {

        CountryEntity countryEntity = countryMapper.fromCountryCreateDto(countryCreateDto);
        CountryEntity countryEntityCreate = countryRepository.save(countryEntity);
        CountryDetailDto countryDetailDto = null;
        if(countryEntityCreate != null) {
            countryDetailDto = countryMapper.fromEntityToDetailDto(countryEntityCreate);
        }
         return countryDetailDto;
    }

}
