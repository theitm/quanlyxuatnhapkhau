package com.haonguyen.CommodityService.iservice;


import com.haonguyen.CommodityService.apiExceptionHandler.SaveException;
import com.haonguyen.CommodityService.dto.*;

import java.util.List;
import java.util.UUID;


public interface ICommodityService {
    void deleteCommodity(UUID id) throws SaveException;
    CommodityCreateDto addCommodity(CommodityCreateDto commodityCreateDto);
    List<TypeOfCommodityDto> findCommodityByIdTypeOfCommodity(UUID idTypeOfCommodity);
    List<CommoditySearchDto> searchCommodity(String key) throws SaveException;
    CommodityUpdateDto updateCommodity(CommodityUpdateDto commodityUpdateDto, UUID idCommodity) throws SaveException;
    CommodityCreateDto CommodityById(UUID id);
    TypeAndTaxCommodityAPI getTypeTaxCommodity(UUID idCommodity) throws Exception;
}
