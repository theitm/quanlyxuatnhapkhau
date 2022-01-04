package ImportExport.service.document;

import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.document.DocumentDetailDto;
import ImportExport.entity.DocumentEntity;
import java.util.Optional;
import java.util.UUID;

public interface DocumentService {
    DocumentDetailDto createDocument(DocumentCreateDto createDto);
    Optional<DocumentEntity> findById(UUID id);
}
