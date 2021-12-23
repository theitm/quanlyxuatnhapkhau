package ImportExport.service;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import ImportExport.entity.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.DocumentRepository;

@Service
@Transactional
public class DocumentServiceImpl {
    @Autowired
    private DocumentRepository repo;

    public List<Document> listAll() {
        return repo.findAll();
    }

    public void save(Document document) {
        repo.save(document);
    }

    public Document get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }

}
