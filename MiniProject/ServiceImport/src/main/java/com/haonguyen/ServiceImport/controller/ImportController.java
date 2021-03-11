package com.haonguyen.ServiceImport.controller;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.haonguyen.ServiceImport.mapper.ImportReceiptMapper;
import com.haonguyen.ServiceImport.mapper.ImportReceiptMapperImpl;
import com.haonguyen.ServiceImport.mapper.ItemReceiptMapper;
import com.haonguyen.ServiceImport.mapper.ItemReceiptMapperImpl;
import com.haonguyen.ServiceImport.repository.IexportRepository;
import com.haonguyen.ServiceImport.service.IexportService;
import com.mini_project.Coremodule.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/api/import")

public class ImportController {

    @Autowired
    private IexportService iexportService;

    public ImportController() {
    }

    @PostMapping("/addReceipt")
    public ResponseEntity addReceipt(@RequestBody ImportReceiptDTO importReceiptDTO) {

        List<ItemReceiptDTO> itemReceiptDTOList = importReceiptDTO.getItem();
        ImportReceiptMapper importReceiptMapper = new ImportReceiptMapperImpl();
        ItemReceiptMapper itemReceiptMapper = new ItemReceiptMapperImpl();
        CountryEntity countryEntity = iexportService.findCountryById(importReceiptDTO.getIdCountry());
        WarehouseEntity warehouseEntity = iexportService.findWarehouseById(importReceiptDTO.getIdWarehouse());
        I_exportEntity iExportEntity = importReceiptMapper.importReceiptDTOToi_exportEntity(importReceiptDTO);
        List<DocumentEntity> documentEntity = itemReceiptMapper.itemReceiptToDocumentEntity(importReceiptDTO.getItem());
        List<DetailsI_exportEntity> detailsIExportEntityList = importReceiptMapper.importReceiptDTOToDetailsEntity(importReceiptDTO);
        List<CommodityEntity> commodityEntityList = new ArrayList<>();
        int Max = 0;

        for (ItemReceiptDTO list : itemReceiptDTOList) {
            CommodityEntity commodityEntity = iexportService.findCommodityById(UUID.fromString(list.getIdCommodity()));
            Max += list.getQuantity();
            commodityEntityList.add(commodityEntity);
        }
        if (Max < warehouseEntity.getCapacity()) {
            for (DetailsI_exportEntity listDetails : detailsIExportEntityList) {
                for (CommodityEntity listCommodity : commodityEntityList) {
                    if (listDetails.getId_commodity() == null) {
                        Double total = listDetails.getQuantity() * listCommodity.getPrice();
                        listDetails.setId_commodity(listCommodity);
                        listDetails.setId_iexport(iExportEntity);
                        listDetails.setTotal(total);
                        commodityEntityList.remove(listCommodity);
                    }
                    break;
                }
            }

            iExportEntity.setId_country(countryEntity);
            iExportEntity.setId_warehouse(warehouseEntity);
            iExportEntity.setDocumentEntities(documentEntity);
            iExportEntity.setCommodityEntities(detailsIExportEntityList);

            I_exportEntity iExportEntityNew = iexportService.saveI_export(iExportEntity);

            return ResponseEntity.ok().body(iExportEntityNew);
        }
        else {
            List<WarehouseEntity> warehouseEntityList = iexportService.findAllWarehouse();
            List<WarehouseEntity> recommendWarehouse = new ArrayList<>();
            for (WarehouseEntity list: warehouseEntityList){
                if(list.getCapacity() > Max)
                    recommendWarehouse.add(list);
            }
            return ResponseEntity.ok().body(recommendWarehouse);
        }
    }

    @PutMapping("/updateReceipt/{idReceipt}")
    public ResponseEntity updateReceipt() {
        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/allReceipt")
    public ResponseEntity getAllReceipt() {
        List<I_exportEntity> exportEntityList = iexportService.getAllReceipt();

        return ResponseEntity.ok().body(exportEntityList);
    }

    @GetMapping("/searchReceipt/{key}")
    public ResponseEntity searchReceipt(@PathVariable(name = "key") String key) {
        List<I_exportEntity> iExportEntityList = iexportService.searchI_export(key);


        return ResponseEntity.ok().body(iExportEntityList);
    }

    @GetMapping("/getReceipt/{idReceipt}")
    public ResponseEntity getReceiptById(@PathVariable(name = "idReceipt") String idReceipt) {

        List<I_exportEntity> exportEntityList = iexportService.getByIdI_Export(UUID.fromString(idReceipt));

        return ResponseEntity.ok().body(exportEntityList);
    }

    @DeleteMapping("/deleteReceipt/{idReceipt}")
    public ResponseEntity deleteReceipt(@PathVariable(name = "idReceipt") String idReceipt) {
        iexportService.deleteById(UUID.fromString(idReceipt));

        return ResponseEntity.ok().body("success");
    }
}
