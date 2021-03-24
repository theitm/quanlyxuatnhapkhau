package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.WarehouseCommodityDTO;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface WarehouseCommodityMapper {
    @Mappings({
            @Mapping(target = "id", source = "importExportEntity.id"),
            @Mapping(target = "idWarehouse", source ="importExportEntity.warehouseEntity"),
            @Mapping(target = "commodityEntities", source ="importExportEntity.detailsImportExportEntities"),
            @Mapping(target = "itemReceiptDTOS", source = "importReceiptDTO.item")
    })
    WarehouseCommodityDTO ToWarehouseCommodityDto(ImportExportEntity importExportEntity, ImportReceiptDTO importReceiptDTO);
}
