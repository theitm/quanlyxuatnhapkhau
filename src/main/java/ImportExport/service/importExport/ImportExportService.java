package ImportExport.service.importExport;

import ImportExport.dto.importExport.*;

import java.util.List;
import java.util.UUID;

public interface ImportExportService {

    ImportExportDetailDto findById(UUID id);
    List<ImportExportDetailDto> findAll();
    ImportExportDetailDto updateImExPort(UUID id, ImportExportCreateDto importExportCreateDto);
    void deleteById(UUID id);
    ImportExportDetailDto createImportExport(ImportExportCreateDto importExportCreateDto);
    ImportExportDto addIE(ImportExportAddDto importExportAddDto);

}