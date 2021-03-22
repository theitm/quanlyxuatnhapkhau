package com.haonguyen.CommodityService.service;

import com.haonguyen.CommodityService.dto.*;
import com.mini_project.CoreModule.entity.CommodityEntity;

import java.util.List;
import java.util.UUID;


public interface ICommodityService {
    void deleteCommodity(UUID id);
    CommodityEntity addCommodity(CommodityCreateDto commodityCreateDto);
    List<TypeOfCommodityDto> findCommodityByIdTypeOfCommodity(UUID idTypeOfCommodity);
    List<CommoditySearchDto> searchCommodity(String key);
    CommodityUpdateDto updateCommodity(CommodityUpdateDto commodityUpdateDto);
    CommodityCreateDto CommodityById(UUID id);
    TypeAndTaxCommodityAPI getTypeTaxCommodity(UUID idCommodity);
}
