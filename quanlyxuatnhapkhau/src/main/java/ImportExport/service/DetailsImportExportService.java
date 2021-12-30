package ImportExport.service;

import ImportExport.entity.DetailsImportExportEntity;

import java.util.Optional;
import java.util.UUID;

public interface DetailsImportExportService {
    Optional<DetailsImportExportEntity> findById(UUID id);
}
