package ImportExport.service;

import ImportExport.entity.WareHouseEntity;
import ImportExport.repository.WareHouseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WareHouseService {
    @Autowired
    private WareHouseRepository repo;
    public List<WareHouseEntity> list(){return (List<WareHouseEntity>) repo.findAll();}
    public void save(WareHouseEntity warehouse){repo.save(warehouse);}
    public WareHouseEntity get(UUID id){return repo.findById(id).get();}
    private WareHouseEntity get() {
            return null;
    }
    public void delete(UUID id){repo.deleteById(id);}
}
