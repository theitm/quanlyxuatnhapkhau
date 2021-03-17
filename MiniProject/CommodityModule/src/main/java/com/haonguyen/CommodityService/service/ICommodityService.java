package com.haonguyen.CommodityService.service;

import com.haonguyen.CommodityService.dto.CommodityCreateDto;
import com.mini_project.Coremodule.entity.CommodityEntity;

import java.util.List;
import java.util.UUID;

public interface ICommodityService {
//    CommodityEntity updateCommodity(CommodityEntity commodityEntity);
//    CommodityEntity findCommodityById(UUID id);
//    void deleteCommodity(UUID id);
//    List<CommodityEntity> findCommodityById_Sectors(UUID id_Sectors);
    CommodityEntity addCommodity(CommodityCreateDto commodityCreateDto);
}
