package ImportExport.service.importExport;

import ImportExport.dto.importExport.ImportExportCreateDto;
import ImportExport.dto.importExport.ImportExportDetailDto;
import ImportExport.entity.ImportExportEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ImportExportService {
    ImportExportDetailDto createImportExport(ImportExportCreateDto importExportCreateDto);
    ImportExportDetailDto findById(UUID id);
    List<ImportExportDetailDto> findAll();
    ImportExportDetailDto updateImExPort(UUID id, ImportExportCreateDto importExportCreateDto);
    void deleteById(UUID id);

}
