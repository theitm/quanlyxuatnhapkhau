package com.haonguyen.CommodityService.iservice;

import com.haonguyen.CommodityService.dto.CommodityInWarehouseDto;

import java.util.List;

public interface IWarehouseService {
    List<CommodityInWarehouseDto> checkCommodityInWarehouse();
}
