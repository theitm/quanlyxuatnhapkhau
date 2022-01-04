package ImportExport.mapper;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;
import ImportExport.entity.DetailsImportExportEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DetailsImportExportMapper {
    DetailsImportExportEntity fromDetailsImportExportCreateDto(DetailsImportExportCreateDto detailsImportExportCreateDto);
    DetailsImportExportDto fromEntityToDto (DetailsImportExportEntity detailsImportExportEntity);
}
