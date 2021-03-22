package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.CommodityDTO;
import com.mini_project.CoreModule.entity.CommodityEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CommodityDTOMapper {
    CommodityEntity toCommodityEntity(CommodityDTO commodityDTO);
}
