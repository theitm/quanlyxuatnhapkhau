package ImportExport.service;

import ImportExport.entity.WareHouseCommodityEntity;
import ImportExport.repository.WareHouseCommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WareHouseCommodityService {
    @Autowired
    private WareHouseCommodityRepository repo;
    public List<WareHouseCommodityEntity> list(){return (List<WareHouseCommodityEntity>) repo.findAll();}
    public void save(WareHouseCommodityEntity wareHouseCommodityEntity){repo.save(wareHouseCommodityEntity);}
    public WareHouseCommodityEntity get(UUID id){return repo.findById(id).get();}
    private WareHouseCommodityEntity get() {
        return null;
    }
    public void delete(UUID id){repo.deleteById(id);}
}
