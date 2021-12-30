package ImportExport.ServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import ImportExport.Mapper.TypeOfCommodityMapper;
import ImportExport.entity.TypeOfCommodityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.TypeOfCommodityRepository;

@Service
@Transactional
public class TypeOfCommodityServiceImpl {

    private final TypeOfCommodityRepository typeOfCommodityRepository;
    private final TypeOfCommodityMapper typeOfCommodityMapper;

    public TypeOfCommodityServiceImpl(TypeOfCommodityRepository typeOfCommodityRepository,
                                      TypeOfCommodityMapper typeOfCommodityMapper){
        this.typeOfCommodityRepository = typeOfCommodityRepository;
        this.typeOfCommodityMapper = typeOfCommodityMapper;
    }

    public Optional<TypeOfCommodityEntity>findById(UUID id){
        return typeOfCommodityRepository.findById(id);
    }

//    @Autowired
//    private TypeOfCommodityRepository repo;
//
//    public List<TypeOfCommodityEntity> list() {
//        return repo.findAll();
//    }
//
//    public void save(TypeOfCommodityEntity typeOfCommodityEntity) {
//        repo.save(typeOfCommodityEntity);
//    }
//
//    public TypeOfCommodityEntity get(UUID id) {
//        return repo.findById(id).get();
//    }
//
//    public void delete(UUID id) {
//        repo.deleteById(id);
//    }

}
