package ImportExport.ServiceImpl;

import ImportExport.Mapper.WareHouseMapper;
import ImportExport.entity.WareHouseEntity;
import ImportExport.repository.WareHouseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class WareHouseServiceImpl {

    private final WareHouseRepository wareHouseRepository;
    private final WareHouseMapper wareHouseMapper;

    public WareHouseServiceImpl(WareHouseRepository wareHouseRepository,
                                WareHouseMapper wareHouseMapper){
        this.wareHouseRepository = wareHouseRepository;
        this.wareHouseMapper = wareHouseMapper;
    }

    public Optional<WareHouseEntity>findById(UUID id){
        return wareHouseRepository.findById(id);
    }

//    @Autowired
//    private WareHouseRepository repo;
//    public List<WareHouseEntity> list(){return repo.findAll();}
//    public void save(WareHouseEntity warehouse){repo.save(warehouse);}
//    public WareHouseEntity get(UUID id){return repo.findById(id).get();}
//    private WareHouseEntity get() {
//            return null;
//    }
//    public void delete(UUID id){repo.deleteById(id);}
}
