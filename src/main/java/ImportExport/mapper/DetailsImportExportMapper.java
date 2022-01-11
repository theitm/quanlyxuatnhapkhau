package ImportExport.mapper;

import ImportExport.dto.detailsImportExport.DetailsIEBasicDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;
import ImportExport.entity.DetailsImportExportEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface DetailsImportExportMapper {
    DetailsImportExportEntity fromDetailsImportExportCreateDto(DetailsImportExportCreateDto detailsImportExportCreateDto);
    DetailsImportExportDto fromEntityToDto (DetailsImportExportEntity detailsImportExportEntity);
    List<DetailsImportExportDto> fromListEntityToDto (List<DetailsImportExportEntity> detailsImportExportEntities);
    DetailsIEBasicDto fromEntityToDtoBasic (DetailsImportExportEntity detailsImportExportEntity);
}
