package ImportExport.ServiceImpl;

import ImportExport.Mapper.TaxBracketMapper;
import ImportExport.entity.TaxBracketEntity;
import ImportExport.repository.TaxBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class TaxBracketServiceImpl {

    private final TaxBracketRepository taxBracketRepository;
    private final TaxBracketMapper taxBracketMapper;

    public TaxBracketServiceImpl(TaxBracketRepository taxBracketRepository,
                                 TaxBracketMapper taxBracketMapper){
        this.taxBracketRepository = taxBracketRepository;
        this.taxBracketMapper = taxBracketMapper;
    }
    public Optional<TaxBracketEntity>findById(UUID id){
        return taxBracketRepository.findById(id);
    }

//    @Autowired
//    private TaxBracketRepository repo;
//    public List<TaxBracketEntity> list(){return repo.findAll();}
//    public void  save(TaxBracketEntity taxBracketEntity){repo.save(taxBracketEntity);}
//    public TaxBracketEntity get(UUID id){return  repo.findById(id).get();}
//    private TaxBracketEntity get(){return null;}
//    public void delete(UUID id){repo.deleteById(id);}
}
