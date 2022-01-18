package ImportExport.mapper;

import ImportExport.dto.importExport.ImportExportAddDto;
import ImportExport.dto.importExport.ImportExportCreateDto;
import ImportExport.dto.importExport.ImportExportDetailDto;
import ImportExport.entity.ImportExportEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface ImportExportMapper {
    ImportExportEntity fromImportExportCreateDto(ImportExportCreateDto importExportCreateDto);
    ImportExportDetailDto fromEntityToDto(ImportExportEntity importExportEntity);
    List<ImportExportDetailDto> fromListEntityToDto (List<ImportExportEntity> importExportEntities);
    ImportExportEntity fromAddDtoToEntity(ImportExportAddDto importExportAddDto);
}
