package ImportExport.service.document;

import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.document.DocumentDetailDto;
import ImportExport.entity.DocumentEntity;
import ImportExport.mapper.DocumentMapper;
import ImportExport.repository.DocumentRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentMapper documentMapper) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
    }
    public Optional<DocumentEntity> findById(UUID id) {
        return documentRepository.findById(id);
    }
    public DocumentDetailDto createDocument(DocumentCreateDto documentCreateDto) {
        DocumentEntity documentEntity = documentMapper.fromDocumentCreateDto(documentCreateDto);
        DocumentEntity documentEntityCreate = documentRepository.save(documentEntity);
        DocumentDetailDto documentDetailDto = null;
        if(documentEntityCreate != null){
            documentDetailDto = documentMapper.fromEntityToDto(documentEntityCreate);
        }
        return documentDetailDto;
    }
}
