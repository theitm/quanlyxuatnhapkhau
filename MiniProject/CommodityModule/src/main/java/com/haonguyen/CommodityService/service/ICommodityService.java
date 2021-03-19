package com.haonguyen.CommodityService.service;

import com.haonguyen.CommodityService.dto.CommodityCreateDto;
<<<<<<< HEAD
import com.haonguyen.CommodityService.dto.CommoditySearchDto;
import com.haonguyen.CommodityService.dto.CommodityUpdateDto;
import com.haonguyen.CommodityService.dto.StyleOfCommodityDto;
import com.mini_project.Coremodule.entity.CommodityEntity;

import java.util.List;
import java.util.UUID;
=======
import com.mini_project.CoreModule.entity.CommodityEntity;
>>>>>>> origin/develop

public interface ICommodityService {
    void deleteCommodity(UUID id);
    CommodityEntity addCommodity(CommodityCreateDto commodityCreateDto);
    List<StyleOfCommodityDto> findCommodityBySectorId(UUID id_sectors);
    List<CommoditySearchDto> searchCommodity(String key);
    CommodityEntity updateCommodity(CommodityUpdateDto commodityUpdateDto);

}
