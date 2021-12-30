package ImportExport.ServiceImpl;

import ImportExport.DTO.CountryDTO;
import ImportExport.Mapper.CountryMapper;
import ImportExport.entity.CountryEntity;
import ImportExport.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CountryServiceImpl {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    public Optional<CountryEntity> findById(UUID id) {
        return countryRepository.findById(id);
    }

    public void fromCountryEntity(CountryEntity countryEntity) {
        CountryDTO countryDTO = countryMapper.fromCountryEntity(countryEntity);
        CountryEntity countryEntity1  = null;
    }
}
