package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;

import java.util.ArrayList;
import java.util.List;

public class ImportReceiptMapperImpl implements ImportReceiptMapper {

    @Override
    public ImportExportEntity importReceiptDTOToi_exportEntity(ImportReceiptDTO importReceiptDTO) {
        if (importReceiptDTO == null) {
            return null;
        }

        ImportExportEntity iExportEntity = new ImportExportEntity();
        iExportEntity.setDate(importReceiptDTO.getDateReceipt());
        iExportEntity.setType(importReceiptDTO.getType());

        return iExportEntity;
    }

    @Override
    public List<DetailsImportExportEntity> importReceiptDTOToDetailsEntity(ImportReceiptDTO importReceiptDTO) {
        if (importReceiptDTO == null) {
            return null;
        }
        List<ItemReceiptDTO> itemReceiptDTOList = importReceiptDTO.getItem();
        List<DetailsImportExportEntity> detailsIExportEntityList = new ArrayList<>();
        for (ItemReceiptDTO list : itemReceiptDTOList) {
            DetailsImportExportEntity detailsIExportEntity = new DetailsImportExportEntity();
            detailsIExportEntity.setDescription(list.getDescription());
            detailsIExportEntity.setQuantity(list.getQuantity());
            detailsIExportEntity.setTotal(list.getTotal());


            detailsIExportEntityList.add(detailsIExportEntity);
        }
        return detailsIExportEntityList;
    }
}
