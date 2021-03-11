package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.haonguyen.ServiceImport.service.IexportService;
import com.haonguyen.ServiceImport.serviceimpl.IexportServiceImpl;
import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.DetailsI_exportEntity;
import com.mini_project.Coremodule.entity.I_exportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ImportReceiptMapperImpl implements ImportReceiptMapper {

    @Override
    public I_exportEntity importReceiptDTOToi_exportEntity(ImportReceiptDTO importReceiptDTO) {
        if (importReceiptDTO == null) {
            return null;
        }

        I_exportEntity iExportEntity = new I_exportEntity();
        iExportEntity.setDate(importReceiptDTO.getDateReceipt());
        iExportEntity.setType(importReceiptDTO.getType());

        return iExportEntity;
    }

    @Override
    public List<DetailsI_exportEntity> importReceiptDTOToDetailsEntity(ImportReceiptDTO importReceiptDTO) {
        if (importReceiptDTO == null) {
            return null;
        }
        List<ItemReceiptDTO> itemReceiptDTOList = importReceiptDTO.getItem();
        List<DetailsI_exportEntity> detailsIExportEntityList = new ArrayList<>();
        for (ItemReceiptDTO list : itemReceiptDTOList) {
            DetailsI_exportEntity detailsIExportEntity = new DetailsI_exportEntity();
            detailsIExportEntity.setDescription(list.getDescription());
            detailsIExportEntity.setQuantity(list.getQuantity());
            detailsIExportEntity.setTotal(list.getTotal());


            detailsIExportEntityList.add(detailsIExportEntity);
        }
        return detailsIExportEntityList;
    }
}
