package com.haonguyen.CommodityService.service;

import com.haonguyen.CommodityService.dto.CommodityInWarehouseDto;

import java.util.List;

public interface IWarehouseService {
    List<CommodityInWarehouseDto> checkCommodityInWarehouse();
}
