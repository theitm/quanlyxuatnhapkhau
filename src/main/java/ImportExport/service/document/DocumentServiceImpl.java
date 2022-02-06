package ImportExport.service.document;

import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.document.DocumentDetailDto;
import ImportExport.entity.DocumentEntity;
import ImportExport.entity.ImportExportEntity;
import ImportExport.mapper.DocumentMapper;
import ImportExport.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentMapper documentMapper) {
        this.documentRepository = documentRepository;
        this.documentMapper = documentMapper;
    }
    public DocumentDetailDto findById(UUID id) {
       DocumentDetailDto documentDetailDto = documentMapper.fromEntityToDto(documentRepository.getById(id));
       return documentDetailDto;
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
    public DocumentDetailDto updateDocument(UUID id, DocumentCreateDto documentCreateDto) {
        DocumentEntity documentEntity = documentMapper.fromDocumentCreateDto(documentCreateDto);
        documentEntity.setId(id);
        documentRepository.save(documentEntity);
        DocumentDetailDto documentDetailDto = documentMapper.fromEntityToDto(documentEntity);
        return documentDetailDto;
    }
    public void deleteById(UUID id) {
        documentRepository.deleteById(id);
    }
    public List<DocumentDetailDto> findAll() {
        return documentMapper.fromListEntityToDto(documentRepository.findAll());
    }
    public DocumentEntity save(List<DocumentEntity> documentEntityList, ImportExportEntity importExportEntity) {
        DocumentEntity documentEntity = null;
        for (DocumentEntity listDocument : documentEntityList) {
            listDocument.setIdImportExport(importExportEntity.getId());
            documentEntity = documentRepository.save(listDocument);
        }
        return documentEntity;
    }
}
