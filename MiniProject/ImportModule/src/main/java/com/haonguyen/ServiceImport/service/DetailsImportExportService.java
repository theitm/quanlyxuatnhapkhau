package com.haonguyen.ServiceImport.service;

import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
import com.mini_project.CoreModule.entity.CommodityEntity;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;

import java.util.List;

public interface DetailsImportExportService {

    DetailsImportExportEntity save(List<DetailsImportExportEntity> detailsIExportEntityList, ImportExportEntity importExportEntity) throws SaveException;

    void setInfoDetailsImportExport(ImportExportEntity iExportEntity, List<DetailsImportExportEntity> detailsIExportEntityList, List<CommodityEntity> commodityEntityList);
}
