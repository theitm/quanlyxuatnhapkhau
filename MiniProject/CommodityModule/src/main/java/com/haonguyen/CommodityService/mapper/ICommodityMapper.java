package com.haonguyen.CommodityService.mapper;

<<<<<<< HEAD
import com.haonguyen.CommodityService.Entity.CheckWarehouseCommodity;
import com.haonguyen.CommodityService.dto.*;
import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.WarehouseCommodityEntity;
=======
import com.haonguyen.CommodityService.dto.CommodityCreateDto;
import com.mini_project.CoreModule.entity.CommodityEntity;
>>>>>>> origin/develop
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICommodityMapper {

    CommodityCreateDto toCreateDto(CommodityEntity entity);
    CommodityEntity fromCreateToEntity(CommodityCreateDto createDto);

    List<CommoditySearchDto> toSearchDto(List<CommodityEntity> commodityEntities);

    CommodityUpdateDto toUpdateDto(CommodityEntity commodityEntity);
    CommodityEntity fromUpdateToEntity(CommodityUpdateDto searchDto);

    List<StyleOfCommodityDto> toFindSectorId(List<CommodityEntity> commodityEntities);

    List<CommodityInWarehouseDto> toCommodityInWarehouse(List<CheckWarehouseCommodity> checkWarehouseCommodities);





}
