package com.haonguyen.CommodityService.mapper;


import com.haonguyen.CommodityService.dto.CommodityCreateDto;
import com.haonguyen.CommodityService.dto.CommodityUpdateDto;
import com.haonguyen.CommodityService.dto.TypeOfCommodityDto;
import com.mini_project.CoreModule.entity.CommodityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICommodityMapper {

    CommodityCreateDto toCreateDto(CommodityEntity entity);

    CommodityEntity fromCreateToEntity(CommodityCreateDto createDto);

    CommodityUpdateDto toUpdateDto(CommodityEntity commodityEntity);

    CommodityEntity fromUpdateToEntity(CommodityUpdateDto searchDto);

    List<TypeOfCommodityDto> toFindSectorId(List<CommodityEntity> commodityEntities);


}
