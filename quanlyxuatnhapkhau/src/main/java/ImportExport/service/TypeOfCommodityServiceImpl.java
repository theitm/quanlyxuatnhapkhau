package ImportExport.service;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import ImportExport.entity.TypeOfCommodityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.TypeOfCommodityRepository;

@Service
@Transactional
public class TypeOfCommodityServiceImpl {
    @Autowired
    private TypeOfCommodityRepository repo;

    public List<TypeOfCommodityEntity> listAll() {
        return repo.findAll();
    }

    public void save(TypeOfCommodityEntity typeOfCommodityEntity) {
        repo.save(typeOfCommodityEntity);
    }

    public TypeOfCommodityEntity get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

}
