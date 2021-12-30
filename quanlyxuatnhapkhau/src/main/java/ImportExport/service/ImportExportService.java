package ImportExport.service;

import ImportExport.entity.ImportExportEntity;

import java.util.Optional;
import java.util.UUID;

public interface ImportExportService {
    Optional<ImportExportEntity>findById(UUID id);
}
