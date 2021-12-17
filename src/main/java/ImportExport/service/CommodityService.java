package ImportExport.service;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import ImportExport.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD:src/main/java/service/CommodityService.java
import repository.CommodityRepository;
=======
import ImportExport.repository.CommodityRepository;
>>>>>>> develop-batch-8-nghia:src/main/java/ImportExport/service/CommodityService.java
@Service
@Transactional
public class CommodityService {

    @Autowired
    private CommodityRepository repo;

    public List<Commodity> listAll() {
        return repo.findAll();
    }

    public void save(Commodity commodity) {
        repo.save(commodity);
    }

    public Commodity get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
