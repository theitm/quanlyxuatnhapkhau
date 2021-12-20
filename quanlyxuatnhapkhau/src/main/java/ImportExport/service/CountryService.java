package ImportExport.service;

import ImportExport.entity.CountryEntity;
import ImportExport.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CountryService {
    @Autowired
    private CountryRepository repo;
    public List<CountryEntity> list(){return (List<CountryEntity>) repo.findAll();}
    public void save(CountryEntity countryEntity){repo.save(countryEntity);}
    public CountryEntity get(UUID id){return repo.findById(id).get();}
    private CountryEntity get() {
        return null;
    }
    public void delete(UUID id){repo.deleteById(id);}
}
