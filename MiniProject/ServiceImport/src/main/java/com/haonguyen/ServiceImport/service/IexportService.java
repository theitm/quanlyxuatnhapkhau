package com.haonguyen.ServiceImport.service;


import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.CountryEntity;
import com.mini_project.Coremodule.entity.I_exportEntity;
import com.mini_project.Coremodule.entity.WarehouseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


public interface IexportService {

    I_exportEntity saveI_export(I_exportEntity iExportEntity);

    List<I_exportEntity> getAllReceipt();

    List<I_exportEntity> getByIdI_Export(UUID idI_Export);

    void deleteById(UUID idI_Export);

    List<I_exportEntity> searchI_export(String key);

    WarehouseEntity findWarehouseById(UUID id);

    CountryEntity findCountryById(UUID id);

    CommodityEntity findCommodityById(UUID id);

    List<WarehouseEntity> findAllWarehouse();

}
