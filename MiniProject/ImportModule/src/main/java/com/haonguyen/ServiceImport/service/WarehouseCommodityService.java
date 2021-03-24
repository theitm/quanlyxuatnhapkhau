package com.haonguyen.ServiceImport.service;

import com.haonguyen.ServiceImport.dto.WarehouseCommodityDTO;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import com.mini_project.CoreModule.entity.WarehouseCommodityEntity;

import java.util.List;

public interface WarehouseCommodityService {
    void save(List<WarehouseCommodityEntity> warehouseCommodityEntityList, ImportExportEntity importExportEntityNew);

    List<WarehouseCommodityEntity> getFromWarehouseCommodityDTO(WarehouseCommodityDTO warehouseCommodityDTO);
}
