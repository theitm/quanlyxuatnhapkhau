package ImportExport.service;


import ImportExport.entity.EmbargoEntity;
import ImportExport.repository.EmbargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmbargoService {
    @Autowired
    private EmbargoRepository repo;
    public List<EmbargoEntity> list(){return (List<EmbargoEntity>) repo.findAll();}
    public void save(EmbargoEntity embargoEntity){repo.save(embargoEntity);}
    public EmbargoEntity get(UUID id){return repo.findById(id).get();}
    private EmbargoEntity get() {
        return null;
    }
    public void delete(UUID id){repo.deleteById(id);}
}
