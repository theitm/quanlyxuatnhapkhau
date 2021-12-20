package ImportExport.service;

import ImportExport.entity.TaxBracketEntity;
import ImportExport.repository.TaxBracketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TaxBracketService {
    @Autowired
    private TaxBracketRepository repo;
    public List<TaxBracketEntity> list(){return (List<TaxBracketEntity>) repo.findAll();}
    public void  save(TaxBracketEntity taxBracketEntity){repo.save(taxBracketEntity);}
    public TaxBracketEntity get(UUID id){return  repo.findById(id).get();}
    private TaxBracketEntity get(){return null;}
    public void delete(UUID id){repo.deleteById(id);}
}
