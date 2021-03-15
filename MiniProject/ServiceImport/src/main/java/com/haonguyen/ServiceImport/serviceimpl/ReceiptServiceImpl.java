package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.haonguyen.ServiceImport.mapper.ImportReceiptMapper;
import com.haonguyen.ServiceImport.mapper.ImportReceiptMapperImpl;
import com.haonguyen.ServiceImport.mapper.ItemReceiptMapper;
import com.haonguyen.ServiceImport.mapper.ItemReceiptMapperImpl;
import com.haonguyen.ServiceImport.service.IexportService;
import com.haonguyen.ServiceImport.service.ReceiptService;
import com.mini_project.Coremodule.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    private IexportService iexportService;

    @Override
    public ResponseEntity getReceipt(ImportReceiptDTO importReceiptDTO) {
        if(importReceiptDTO == null){
            return null;
        }

        List<ItemReceiptDTO> itemReceiptDTOList = importReceiptDTO.getItem();

        ImportReceiptMapper importReceiptMapper = new ImportReceiptMapperImpl();

        ItemReceiptMapper itemReceiptMapper = new ItemReceiptMapperImpl();

        CountryEntity countryEntity = iexportService.findCountryById(importReceiptDTO.getIdCountry());

        WarehouseEntity warehouseEntity = iexportService.findWarehouseById(importReceiptDTO.getIdWarehouse());

        I_exportEntity iExportEntity = importReceiptMapper.importReceiptDTOToi_exportEntity(importReceiptDTO);

        List<DocumentEntity> documentEntityList = itemReceiptMapper.itemReceiptToDocumentEntity(importReceiptDTO.getItem());

        List<DetailsI_exportEntity> detailsIExportEntityList = importReceiptMapper.importReceiptDTOToDetailsEntity(importReceiptDTO);

        List<CommodityEntity> commodityEntityList = new ArrayList<>();

        int Max = 0;

        for (ItemReceiptDTO list : itemReceiptDTOList) {
            CommodityEntity commodityEntity = iexportService.findCommodityById(UUID.fromString(list.getIdCommodity()));
            Max += list.getQuantity();
            commodityEntityList.add(commodityEntity);
        }

        for (DocumentEntity listDocument: documentEntityList){
            listDocument.setId_iexport(iExportEntity);
        }

        if (Max < warehouseEntity.getCapacity()) {
            for (DetailsI_exportEntity listDetails : detailsIExportEntityList) {
                for (CommodityEntity listCommodity : commodityEntityList) {
                    Double total = listDetails.getQuantity() * listCommodity.getPrice();
                    listDetails.setId_commodity(listCommodity);
                    listDetails.setId_iexport(iExportEntity);
                    listDetails.setTotal(total);
                    commodityEntityList.remove(listCommodity);
                    break;
                }
            }

            iExportEntity.setId_country(countryEntity);
            iExportEntity.setId_warehouse(warehouseEntity);
            iExportEntity.setDocumentEntities(documentEntityList);
            iExportEntity.setCommodityEntities(detailsIExportEntityList);

            I_exportEntity iExportEntityNew = iexportService.saveI_export(iExportEntity);

            return ResponseEntity.ok().body(iExportEntityNew);
        } else {
            List<WarehouseEntity> warehouseEntityList = iexportService.findAllWarehouse();
            List<WarehouseEntity> recommendWarehouse = new ArrayList<>();
            for (WarehouseEntity list : warehouseEntityList) {
                if (list.getCapacity() > Max)
                    recommendWarehouse.add(list);
            }
            return ResponseEntity.ok().body(recommendWarehouse);
        }
    }
}
