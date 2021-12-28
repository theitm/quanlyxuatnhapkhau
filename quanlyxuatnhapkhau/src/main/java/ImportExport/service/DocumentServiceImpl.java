package ImportExport.service;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import ImportExport.entity.DocumentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.DocumentRepository;

@Service
@Transactional
public class DocumentServiceImpl {
    @Autowired
    private DocumentRepository repo;

    public List<DocumentEntity> listAll() {
        return repo.findAll();
    }

    public void save(DocumentEntity documentEntity) {
        repo.save(documentEntity);
    }

    public DocumentEntity get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

}