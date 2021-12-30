package ImportExport.Mapper;

import ImportExport.DTO.DetailsImportExportDTO;
import ImportExport.entity.DetailsImportExportEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DetailsImportExportMapper {
    DetailsImportExportEntity fromDetailsImportExportDTO(DetailsImportExportDTO detailsImportExportDTO);
    DetailsImportExportDTO fromDetailsImportExportEntity(DetailsImportExportEntity detailsImportExportEntity);
}
