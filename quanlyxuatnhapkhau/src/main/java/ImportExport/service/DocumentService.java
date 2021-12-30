package ImportExport.service;

import ImportExport.entity.DocumentEntity;

import java.util.Optional;
import java.util.UUID;

public interface DocumentService {
    Optional<DocumentEntity>findById(UUID id);
}
