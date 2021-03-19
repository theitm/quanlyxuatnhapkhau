package com.haonguyen.CommodityService.service;

import com.haonguyen.CommodityService.dto.CommodityInWarehouseDto;
import com.haonguyen.CommodityService.mapper.ICommodityMapper;
import com.haonguyen.CommodityService.mapper.ICommodityMapperImpl;
import com.haonguyen.CommodityService.repository.ICommodityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService implements IWarehouseService{
    private final ICommodityRepository iCommodityRepository;
    private final ICommodityMapper iCommodityMapper;

    public WarehouseService(ICommodityRepository iCommodityRepository, ICommodityMapper iCommodityMapper) {
        this.iCommodityRepository = iCommodityRepository;
        this.iCommodityMapper = iCommodityMapper;
    }


    @Override
    public List<CommodityInWarehouseDto> checkCommodityInWarehouse() {
        List<CommodityInWarehouseDto> commodityInWarehouseDtos = iCommodityRepository.CommodityInWarehouse();
        return commodityInWarehouseDtos;
    }
}
