package com.haonguyen.CommodityService.iservice;


import com.haonguyen.CommodityService.dto.*;

import java.util.List;
import java.util.UUID;


public interface ICommodityService {
    void deleteCommodity(UUID id);
    CommodityCreateDto addCommodity(CommodityCreateDto commodityCreateDto);
    List<TypeOfCommodityDto> findCommodityByIdTypeOfCommodity(UUID idTypeOfCommodity);
    List<CommoditySearchDto> searchCommodity(String key);
    CommodityUpdateDto updateCommodity(CommodityUpdateDto commodityUpdateDto, UUID idCommodity);
    CommodityCreateDto CommodityById(UUID id);
    TypeAndTaxCommodityAPI getTypeTaxCommodity(UUID idCommodity);
}
