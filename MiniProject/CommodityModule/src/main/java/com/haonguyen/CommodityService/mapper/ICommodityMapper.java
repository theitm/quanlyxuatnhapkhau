package com.haonguyen.CommodityService.mapper;

import com.haonguyen.CommodityService.dto.CommodityCreateDto;
import com.mini_project.Coremodule.entity.CommodityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICommodityMapper {

    CommodityCreateDto toCreateDto(CommodityEntity entity);

    CommodityEntity fromCreateToEntity(CommodityCreateDto createDto);

    List<CommodityCreateDto> toCreateDto(List<CommodityEntity> entity);

    List<CommodityEntity> fromCreateToEntity(List<CommodityCreateDto> createDto);

}
