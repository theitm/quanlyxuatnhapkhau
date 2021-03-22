package com.haonguyen.ExportService.mapper;


import com.haonguyen.ExportService.dto.ExcelExportDTO;
import com.haonguyen.ExportService.dto.ExportDTO;
import com.haonguyen.ExportService.dto.ExportFindByIdDTO;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IImportExportMapper {

    ExportFindByIdDTO toExportFindByIdDTO(ImportExportEntity importExportEntity);
    @Mappings({
            @Mapping(source = "countryEntity.countryName",target = "countryName"),
            @Mapping(source = "warehouseEntity.warehouseName",target = "warehouseName")
    })
    ExcelExportDTO toExcelExportDTO(ImportExportEntity importExportEntities);
    // toExcelExportDTO neu ko co thi truong countryName and warehouseName se null;
    List<ExcelExportDTO> toExcelExportDTOs(List<ImportExportEntity> importExportEntities);


    ExportDTO toExportDTO(ImportExportEntity importExportEntities);
    List<ExportDTO> toExportDTOs(List<ImportExportEntity> importExportEntities);

}
