package ImportExport.service.document;

import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.document.DocumentDetailDto;
import ImportExport.entity.DocumentEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DocumentService {
    DocumentDetailDto createDocument(DocumentCreateDto createDto);
    DocumentDetailDto findById(UUID id);
    List<DocumentDetailDto> findAll();
    DocumentDetailDto updateDocument(UUID id, DocumentCreateDto documentCreateDto);
    void deleteById(UUID id);
}
