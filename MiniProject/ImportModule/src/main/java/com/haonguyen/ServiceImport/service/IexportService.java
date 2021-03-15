package com.haonguyen.ServiceImport.service;


import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.CountryEntity;
import com.mini_project.Coremodule.entity.Import_ExportEntity;
import com.mini_project.Coremodule.entity.WarehouseEntity;

import java.util.List;
import java.util.UUID;


public interface IexportService {

    Import_ExportEntity saveI_export(Import_ExportEntity iExportEntity);

    List<Import_ExportEntity> getAllReceipt();

    List<Import_ExportEntity> getByIdI_Export(UUID idI_Export);

    void deleteById(UUID idI_Export);

    List<Import_ExportEntity> searchI_export(String key);

    WarehouseEntity findWarehouseById(UUID id);

    CountryEntity findCountryById(UUID id);

    CommodityEntity findCommodityById(UUID id);

    List<WarehouseEntity> findAllWarehouse();

}
