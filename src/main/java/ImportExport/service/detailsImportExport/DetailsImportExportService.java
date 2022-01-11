package ImportExport.service.detailsImportExport;

import ImportExport.dto.detailsImportExport.DetailsIEBasicDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;
import ImportExport.entity.DetailsImportExportEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface DetailsImportExportService {
    DetailsImportExportDto createDetailsImportExport(DetailsImportExportCreateDto detailsImportExportCreateDto);
    DetailsImportExportDto findById(UUID id);
    DetailsImportExportDto updateDetailsImportExport(UUID id, DetailsImportExportCreateDto detailsImportExportCreateDto);
    List<DetailsImportExportDto> findAll();
    void deleteById(UUID id);
}
