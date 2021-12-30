package ImportExport.ServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import ImportExport.Mapper.DetailsImportExportMapper;
import ImportExport.Mapper.DocumentMapper;
import ImportExport.entity.DetailsImportExportEntity;
import ImportExport.entity.DocumentEntity;
import ImportExport.repository.DetailsImportExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.DocumentRepository;

@Service
@Transactional
public class DocumentServiceImpl {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    public DocumentServiceImpl(DocumentRepository documentRepository,
                               DocumentMapper documentMapper){
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
    }

    public Optional<DocumentEntity> findById(UUID id){
        return documentRepository.findById(id);
    }

//    @Autowired
//    private DocumentRepository repo;
//
//    public List<DocumentEntity> list() {
//        return repo.findAll();
//    }
//
//    public void save(DocumentEntity documentEntity) {
//        repo.save(documentEntity);
//    }
//
//    public DocumentEntity get(UUID id) {
//        return repo.findById(id).get();
//    }
//
//    public void delete(UUID id) {
//        repo.deleteById(id);
//    }

}
