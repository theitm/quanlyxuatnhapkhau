package ImportExport.ServiceImpl;


import ImportExport.Mapper.DocumentMapper;
import ImportExport.Mapper.EmbargoMapper;
import ImportExport.entity.DocumentEntity;
import ImportExport.entity.EmbargoEntity;
import ImportExport.repository.DocumentRepository;
import ImportExport.repository.EmbargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class EmbargoServiceImpl {

    private final EmbargoRepository embargoRepository;
    private final EmbargoMapper embargoMapper;

    public EmbargoServiceImpl(EmbargoRepository embargoRepository,
                              EmbargoMapper embargoMapper){
        this.embargoRepository = embargoRepository;
        this.embargoMapper = embargoMapper;
    }

    public Optional<EmbargoEntity> findById(UUID id){
        return embargoRepository.findById(id);
    }

//    @Autowired
//    private EmbargoRepository repo;
//    public List<EmbargoEntity> list(){return repo.findAll();}
//    public void save(EmbargoEntity embargoEntity){repo.save(embargoEntity);}
//    public EmbargoEntity get(UUID id){return repo.findById(id).get();}
//    private EmbargoEntity get() {
//        return null;
//    }
//    public void delete(UUID id){repo.deleteById(id);}
}
