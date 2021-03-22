package com.haonguyen.ServiceImport.service;

import com.mini_project.CoreModule.entity.CommodityEntity;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;

import java.util.List;

public interface DetailsImportExportService {

    void save(List<DetailsImportExportEntity> detailsIExportEntityList, ImportExportEntity importExportEntity);

    void setInfoDetailsImportExport(ImportExportEntity iExportEntity, List<DetailsImportExportEntity> detailsIExportEntityList, List<CommodityEntity> commodityEntityList);
}
