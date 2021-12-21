package ImportExport.service;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import ImportExport.entity.TypeOfCommodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.TypeOfCommodityRepository;

@Service
@Transactional
public class TypeOfCommodityService {
    @Autowired
    private TypeOfCommodityRepository repo;

    public List<TypeOfCommodity> listAll() {
        return repo.findAll();
    }

    public void save(TypeOfCommodity typeOfCommodity) {
        repo.save(typeOfCommodity);
    }

    public TypeOfCommodity get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

}
