package ImportExport.mapper;

import ImportExport.dto.importExport.ImportExportCreateDto;
import ImportExport.dto.importExport.ImportExportDetailDto;
import ImportExport.entity.ImportExportEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ImportExportMapper {
    ImportExportEntity fromImportExportCreateDto(ImportExportCreateDto importExportCreateDto);
    ImportExportDetailDto fromEntityToDto(ImportExportEntity importExportEntity);
}
