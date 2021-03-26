package com.haonguyen.ExportService.mapper;

import com.haonguyen.ExportService.dto.ApiInfoCommodity;
import com.haonguyen.ExportService.dto.DetailsExportDTO;
import com.haonguyen.ExportService.dto.excel.ExcelDetailsExportDTO;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDetailsExportMapper {

    @Mappings({
            @Mapping(source = "commodityId" , target = "idCommodity"),
            @Mapping(source = "commodityName",target = "commodityName"),
            @Mapping(source = "typeOfCommodityName",target = "typeOfCommodityName"),
            @Mapping(source = "commodityPrice",target = "price")
    })
    ExcelDetailsExportDTO toExcelDetailsExportDTO(ApiInfoCommodity apiInfoCommodity);
    List<ExcelDetailsExportDTO> toExcelDetailsExportDTOs(List<ApiInfoCommodity> apiInfoCommodities);



    DetailsExportDTO toDetailsExportDTO(DetailsImportExportEntity detailsImportExportEntity);
    List<DetailsExportDTO> toDetailsExportDTOs(List<DetailsImportExportEntity> detailsImportExportEntities);
}
