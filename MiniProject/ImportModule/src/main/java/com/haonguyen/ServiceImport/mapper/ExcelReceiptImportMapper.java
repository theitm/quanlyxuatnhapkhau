package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ExcelReceiptImportDTO;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ExcelReceiptImportMapper {
    @Mappings({
            @Mapping(target = "countryName", source = "importExportEntity.countryEntity.countryName"),
            @Mapping(target = "warehouseName", source = "importExportEntity.warehouseEntity.warehouseName")
    })
    ExcelReceiptImportDTO toExcelReceiptImportDTO(ImportExportEntity importExportEntity);
}
