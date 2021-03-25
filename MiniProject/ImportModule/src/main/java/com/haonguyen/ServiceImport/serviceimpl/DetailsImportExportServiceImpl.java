package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
import com.haonguyen.ServiceImport.repository.DetailsImportExportRepository;
import com.haonguyen.ServiceImport.service.DetailsImportExportService;
import com.mini_project.CoreModule.entity.CommodityEntity;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsImportExportServiceImpl implements DetailsImportExportService {
    @Autowired
    private DetailsImportExportRepository detailsImportExportRepository;

    @Override
    public DetailsImportExportEntity save(List<DetailsImportExportEntity> detailsIExportEntityList, ImportExportEntity importExportEntity) throws SaveException {
        DetailsImportExportEntity detailsImportExportEntity = null;
        for (DetailsImportExportEntity listDetails : detailsIExportEntityList) {
            listDetails.setIdImportExport(importExportEntity.getId());
            detailsImportExportEntity = detailsImportExportRepository.save(listDetails);
        }
        if(detailsImportExportEntity == null){
            throw new SaveException("Save Error At DetailsImportExportEntity Please Try Again");
        }
        return detailsImportExportEntity;
    }

    @Override
    public void setInfoDetailsImportExport(ImportExportEntity iExportEntity, List<DetailsImportExportEntity> detailsIExportEntityList, List<CommodityEntity> commodityEntityList) {
        for (DetailsImportExportEntity listDetails : detailsIExportEntityList) {
            for (CommodityEntity listCommodity : commodityEntityList) {
                Double total = listDetails.getQuantity() * listCommodity.getPrice();
                listDetails.setImportExportEntity(iExportEntity);
                listDetails.setCommodityEntity(listCommodity);
                listDetails.setTotal(total);
                commodityEntityList.remove(listCommodity);
                break;
            }
        }
    }
}
