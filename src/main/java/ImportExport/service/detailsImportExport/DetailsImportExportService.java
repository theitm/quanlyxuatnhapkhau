package ImportExport.service.detailsImportExport;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;
import ImportExport.entity.DetailsImportExportEntity;
import java.util.Optional;
import java.util.UUID;


public interface DetailsImportExportService {
    DetailsImportExportDto createDetailsImportExport(DetailsImportExportCreateDto detailsImportExportCreateDto);
    Optional<DetailsImportExportEntity> findById(UUID id);
}
