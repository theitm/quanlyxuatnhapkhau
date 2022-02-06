package ImportExport.mapper;

import ImportExport.dto.detailsImportExport.DetailsImportExportBasicDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;
import ImportExport.dto.importExport.ImportExportAddDto;
import ImportExport.entity.DetailsImportExportEntity;
import ImportExport.entity.DocumentEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface DetailsImportExportMapper {
    DetailsImportExportEntity fromDetailsImportExportCreateDto(DetailsImportExportCreateDto detailsImportExportCreateDto);
    DetailsImportExportDto fromEntityToDto (DetailsImportExportEntity detailsImportExportEntity);
    List<DetailsImportExportDto> fromListEntityToDto (List<DetailsImportExportEntity> detailsImportExportEntities);
    DetailsImportExportBasicDto fromEntityToDtoBasic (DetailsImportExportEntity detailsImportExportEntity);
    List<DetailsImportExportBasicDto> fromListEntityBasicToDto(List<DetailsImportExportEntity> detailsImportExportEntities);
    List<DetailsImportExportEntity> fromListDtoToEntity (List<DetailsImportExportCreateDto> detailsImportExportCreateDtoList);
    List<DocumentEntity> fromListDtoToDocumentEntity (List<DetailsImportExportCreateDto> detailsImportExportCreateDtoList);

}
