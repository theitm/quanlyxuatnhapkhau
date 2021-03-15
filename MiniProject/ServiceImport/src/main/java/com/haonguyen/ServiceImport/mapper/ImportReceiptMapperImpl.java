package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.mini_project.CoreModule.entity.DetailsImport_ExportEntity;
import com.mini_project.CoreModule.entity.Import_ExportEntity;
import com.mini_project.CoreModule.entity.CommodityEntity;

import java.util.ArrayList;
import java.util.List;

public class ImportReceiptMapperImpl implements ImportReceiptMapper {

    @Override
    public Import_ExportEntity importReceiptDTOToi_exportEntity(ImportReceiptDTO importReceiptDTO) {
        if (importReceiptDTO == null) {
            return null;
        }

        Import_ExportEntity iExportEntity = new Import_ExportEntity();
        iExportEntity.setDate(importReceiptDTO.getDateReceipt());
        iExportEntity.setType(importReceiptDTO.getType());

        return iExportEntity;
    }

    @Override
    public List<DetailsImport_ExportEntity> importReceiptDTOToDetailsEntity(ImportReceiptDTO importReceiptDTO) {
        if (importReceiptDTO == null) {
            return null;
        }
        List<ItemReceiptDTO> itemReceiptDTOList = importReceiptDTO.getItem();
        List<DetailsImport_ExportEntity> detailsIExportEntityList = new ArrayList<>();
        for (ItemReceiptDTO list : itemReceiptDTOList) {
            DetailsImport_ExportEntity detailsIExportEntity = new DetailsImport_ExportEntity();
            detailsIExportEntity.setDescription(list.getDescription());
            detailsIExportEntity.setQuantity(list.getQuantity());
            detailsIExportEntity.setTotal(list.getTotal());


            detailsIExportEntityList.add(detailsIExportEntity);
        }
        return detailsIExportEntityList;
    }
}
