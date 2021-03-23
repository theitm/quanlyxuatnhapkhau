package com.haonguyen.ServiceImport.service;


import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.mini_project.CoreModule.entity.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public interface ImportExportService {

    ImportExportEntity saveI_export(ImportExportEntity iExportEntity, ImportReceiptDTO importReceiptDTO);

    List<ImportExportEntity> getAllReceipt();

    ImportExportEntity getByIdI_Export(UUID idI_Export);

    void deleteById(UUID idI_Export);

    List<ImportExportEntity> searchImportExport(String key, Date date);

    WarehouseEntity findWarehouseById(UUID id);

    CountryEntity findCountryById(UUID id);

    CommodityEntity findCommodityById(UUID id);

    List<WarehouseEntity> findAllWarehouse();

    List<ImportExportEntity> findAllByDate(Date date);

    List<WarehouseCommodityEntity> findWarehouseCommodityByTwoId(UUID idWarehouse, UUID idCommodity);

    List<WarehouseEntity> getWarehouseEntityList(int Max);

    void setInfoImportExport(CountryEntity countryEntity, WarehouseEntity warehouseEntity, ImportExportEntity iExportEntity, List<DocumentEntity> documentEntityList, List<DetailsImportExportEntity> detailsIExportEntityList);

}
