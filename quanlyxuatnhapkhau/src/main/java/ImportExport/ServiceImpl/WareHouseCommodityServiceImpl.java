package ImportExport.ServiceImpl;

import ImportExport.Mapper.WareHouseCommodityMapper;
import ImportExport.entity.WareHouseCommodityEntity;
import ImportExport.repository.WareHouseCommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class WareHouseCommodityServiceImpl {

    private final WareHouseCommodityRepository wareHouseCommodityRepository;
    private final WareHouseCommodityMapper wareHouseCommodityMapper;

    public WareHouseCommodityServiceImpl(WareHouseCommodityRepository wareHouseCommodityRepository,
                                         WareHouseCommodityMapper wareHouseCommodityMapper){
        this.wareHouseCommodityRepository = wareHouseCommodityRepository;
        this.wareHouseCommodityMapper = wareHouseCommodityMapper;
    }

    public Optional<WareHouseCommodityEntity>findById(UUID id){
        return wareHouseCommodityRepository.findById(id);
    }

//    @Autowired
//    private WareHouseCommodityRepository repo;
//    public List<WareHouseCommodityEntity> list(){return repo.findAll();}
//    public void save(WareHouseCommodityEntity wareHouseCommodityEntity){repo.save(wareHouseCommodityEntity);}
//    public WareHouseCommodityEntity get(UUID id){return repo.findById(id).get();}
//    private WareHouseCommodityEntity get() {
//        return null;
//    }
//    public void delete(UUID id){repo.deleteById(id);}
}
