package ImportExport.service.detailsImportExport;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;

import java.util.List;
import java.util.UUID;


public interface DetailsImportExportService {
    DetailsImportExportDto createDetailsImportExport(DetailsImportExportCreateDto detailsImportExportCreateDto);
    DetailsImportExportDto findById(UUID id);
    DetailsImportExportDto updateDetailsImportExport(UUID id, DetailsImportExportCreateDto detailsImportExportCreateDto);
    List<DetailsImportExportDto> findAll();
    void deleteById(UUID id);

}
