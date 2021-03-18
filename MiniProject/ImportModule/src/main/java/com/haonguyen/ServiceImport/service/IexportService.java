package com.haonguyen.ServiceImport.service;


import com.mini_project.CoreModule.entity.CommodityEntity;
import com.mini_project.CoreModule.entity.CountryEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import com.mini_project.CoreModule.entity.WarehouseEntity;

import java.util.List;
import java.util.UUID;


public interface IexportService {

    ImportExportEntity saveI_export(ImportExportEntity iExportEntity);

    List<ImportExportEntity> getAllReceipt();

    List<ImportExportEntity> getByIdI_Export(UUID idI_Export);

    void deleteById(UUID idI_Export);

    List<ImportExportEntity> searchI_export(String key);

    WarehouseEntity findWarehouseById(UUID id);

    CountryEntity findCountryById(UUID id);

    CommodityEntity findCommodityById(UUID id);

    List<WarehouseEntity> findAllWarehouse();

}
