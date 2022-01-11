package ImportExport.service.country;

import ImportExport.dto.country.CountryCreateDto;
import ImportExport.dto.country.CountryDetailDto;
import ImportExport.entity.CountryEntity;
import ImportExport.mapper.CountryMapper;
import ImportExport.repository.CountryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    /**
     * Hiện quốc gia theo ID
     * @param id
     * @return
     */
    public CountryDetailDto findById(UUID id) {
        CountryDetailDto countryDetailDto = countryMapper.fromEntityToDetailDto(countryRepository.getById(id));
        return countryDetailDto;
    }

    /**
     * Hiện danh sách các quốc gia
     * @return
     */
    public List<CountryDetailDto> findAll(){
        return countryMapper.fromEntityToDto(countryRepository.findAll());
    }

    /**
     * Tạo một quốc gia mới
     * @param countryCreateDto
     * @return
     */
    public CountryDetailDto createCountry(CountryCreateDto countryCreateDto) {

        CountryEntity countryEntity = countryMapper.fromCountryCreateDto(countryCreateDto);
        CountryEntity countryEntityCreate = countryRepository.save(countryEntity);
        CountryDetailDto countryDetailDto =null;
        if(countryEntityCreate != null) {
            countryDetailDto = countryMapper.fromEntityToDetailDto(countryEntityCreate);
        }
         return countryDetailDto;
    }

    public CountryDetailDto updateCountry(UUID id ,  CountryCreateDto countryCreateDto) {
        CountryEntity countryEntity = countryMapper.fromCountryCreateDto(countryCreateDto);
        countryEntity.setId(id);
        countryRepository.save(countryEntity);
        CountryDetailDto countryDetailDto = countryMapper.fromEntityToDetailDto(countryEntity);
        return countryDetailDto;
    }

    public void deleteById(UUID id) {
        countryRepository.deleteById(id);
    }

}
