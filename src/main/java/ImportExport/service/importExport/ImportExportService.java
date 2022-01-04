package ImportExport.service.importExport;

import ImportExport.dto.importExport.ImportExportCreateDto;
import ImportExport.dto.importExport.ImportExportDetailDto;
import ImportExport.entity.ImportExportEntity;
import java.util.Optional;
import java.util.UUID;

public interface ImportExportService {
    ImportExportDetailDto createImportExport(ImportExportCreateDto importExportCreateDto);
    Optional<ImportExportEntity> findById(UUID id);
}
