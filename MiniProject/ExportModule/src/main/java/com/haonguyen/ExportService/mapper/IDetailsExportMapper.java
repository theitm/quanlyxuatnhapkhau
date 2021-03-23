package com.haonguyen.ExportService.mapper;

import com.haonguyen.ExportService.dto.ApiAllCommodityInfo;
import com.haonguyen.ExportService.dto.DetailsExportDTO;
import com.haonguyen.ExportService.dto.DocumentDTO;
import com.haonguyen.ExportService.dto.excel.ExcelDetailsExportDTO;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.DocumentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import javax.crypto.spec.PSource;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IDetailsExportMapper {

    @Mappings({
            @Mapping(source = "commodityId" , target = "idCommodity"),
            @Mapping(source = "commodityName",target = "commodityName"),
            @Mapping(source = "typeOfCommodityName",target = "typeOfCommodityName"),
            @Mapping(source = "commodityPrice",target = "price")
    })
    ExcelDetailsExportDTO toExcelDetailsExportDTO(ApiAllCommodityInfo apiAllCommodityInfo);
    List<ExcelDetailsExportDTO> toExcelDetailsExportDTOs(List<ApiAllCommodityInfo> apiAllCommodityInfos);



    DetailsExportDTO toDetailsExportDTO(DetailsImportExportEntity detailsImportExportEntity);
    List<DetailsExportDTO> toDetailsExportDTOs(List<DetailsImportExportEntity> detailsImportExportEntities);
}
