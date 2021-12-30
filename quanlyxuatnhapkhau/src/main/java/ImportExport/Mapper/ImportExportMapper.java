package ImportExport.Mapper;

import ImportExport.DTO.ImportExportDTO;
import ImportExport.entity.ImportExportEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ImportExportMapper {
    ImportExportEntity fromImportExportDTO(ImportExportDTO importExportDTO);
    ImportExportDTO fromImportExportEntity(ImportExportEntity importExportEntity);
}
