package com.haonguyen.ServiceImport.controller;

import com.haonguyen.ServiceImport.dto.*;
import com.haonguyen.ServiceImport.entity.*;
import com.haonguyen.ServiceImport.repository.IexportRepository;
import com.haonguyen.ServiceImport.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/import")

public class ImportController {
    @Autowired
    private IexportService iexportService;
    @Autowired
    private DetailsIexportService detailsIexportService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private IexportRepository iexportRepository;

    public ImportController() {
    }

//    @PostMapping("/addReceipt")
//    public ResponseEntity addReceipt(@RequestBody ImportReceiptEntityDTO importReceiptEntityDTO) {
//        CountryEntityDTO countryEntityDTO = iexportService.findCountryByName(importReceiptEntityDTO.getNameCountry());
//        WarehouseEntityDTO warehouseEntityDTO = iexportService.findWarehouseByName(importReceiptEntityDTO.getNameWarehouse());
//        List<CommodityWarehouseDTO> commodityWarehouseDTOList = commodityWarehouseService.listAllInformation();
//        List<CommodityEntity> commodityEntityList = new ArrayList<>();
//        List<ItemReceiptEntityDTO> receiptCommodityList = importReceiptEntityDTO.getItem();
//        List<DetailsI_exportEntity> detailsIExportEntityList = new ArrayList<>();
//        List<DocumentEntity> documentEntityList = new ArrayList<>();
//        Double Mass = 0.0;
//        I_exportEntity iExportEntityNew;
//
//        List<String> checkName = new ArrayList<>();
//        for (ItemReceiptEntityDTO lstCommodity : receiptCommodityList) {
//            CommodityEntity commodityEntity = commodityService.findByCommodityName(lstCommodity.getNameCommodity());
//            commodityEntityList.add(commodityEntity);
//        }
//
//        I_exportEntity iExportEntity = I_exportEntity.builder()
//                .idCountry(countryEntityDTO.getIdCountry().toString())
//                .idWarehouse(warehouseEntityDTO.getIdWarehouse().toString())
//                .dateReceipt(importReceiptEntityDTO.getDateReceipt())
//                .type(importReceiptEntityDTO.getType())
//                .build();
//
//        for (CommodityEntity lstCommodity : commodityEntityList) {
//            for (ItemReceiptEntityDTO lstCommodityReceipt : receiptCommodityList) {
//                if (lstCommodity.getCommodityName().equalsIgnoreCase(lstCommodityReceipt.getNameCommodity())) {
//                    Mass += lstCommodityReceipt.getQuantity() * Double.parseDouble(lstCommodity.getUnit()) / 1000;
//                    Double total = lstCommodity.getPrice() * lstCommodityReceipt.getQuantity();
//                    DetailsI_exportEntity detailsIExportEntity = DetailsI_exportEntity.builder()
//                            .idCommodity(CommodityEntity.builder()
//                                    .idCommodity(lstCommodity.getIdCommodity())
//                                    .idSectors(lstCommodity.getIdSectors())
//                                    .commodityName(lstCommodity.getCommodityName())
//                                    .description(lstCommodity.getDescription())
//                                    .price(lstCommodity.getPrice())
//                                    .unit(lstCommodity.getUnit())
//                                    .build())
//                            .idI_Export(iExportEntity)
//                            .description(lstCommodityReceipt.getDescription())
//                            .quantity(lstCommodityReceipt.getQuantity())
//                            .total(total)
//                            .build();
//
//                    DocumentEntity documentEntity = DocumentEntity.builder()
//                            .imageUrl(lstCommodityReceipt.getImageUrl().toString())
//                            .build();
//
//                    documentEntityList.add(documentEntity);
//                    detailsIExportEntityList.add(detailsIExportEntity);
//                }
//            }
//        }
//
//        if (Mass < warehouseEntityDTO.getCapacity()) {
//            iExportEntity.setCommodityEntities(detailsIExportEntityList);
//            iExportEntity.setDocumentEntities(documentEntityList);
//
//            iExportEntityNew = iexportService.saveI_export(iExportEntity);
//
//            for (CommodityEntity lstCommodity : commodityEntityList)
//                outerLoop:{
//                    for (ItemReceiptEntityDTO lstCommodityReceipt : receiptCommodityList) {
//                        checkName.add(lstCommodityReceipt.getNameCommodity());
//                        for (String lstCheckName : checkName) {
//                            if (lstCommodityReceipt.getNameCommodity().equalsIgnoreCase(lstCheckName)) {
//                                break;
//                            }
//                        }
//                        if (lstCommodity.getCommodityName().equalsIgnoreCase(lstCommodityReceipt.getNameCommodity())) {
//                            if (commodityWarehouseDTOList.size() == 0) {
//                                CommodityWarehouseDTO commodityWarehouseDTO = CommodityWarehouseDTO.builder()
//                                        .idWarehouse(warehouseEntityDTO.getIdWarehouse().toString())
//                                        .idCommodity(lstCommodity.getIdCommodity().toString())
//                                        .inventoryNumber(lstCommodityReceipt.getQuantity())
//                                        .build();
//                                commodityWarehouseService.save(commodityWarehouseDTO);
//
//                            } else {
//                                List<CommodityWarehouseDTO> commodityWarehouseEntities = commodityWarehouseService.findALlByTwoId(warehouseEntityDTO.getIdWarehouse().toString(), lstCommodity.getIdCommodity().toString());
//                                if (commodityWarehouseEntities.size() > 0) {
//                                    for (CommodityWarehouseDTO listFindByTwoId : commodityWarehouseEntities) {
//                                        Double sT = listFindByTwoId.getInventoryNumber() + lstCommodityReceipt.getQuantity();
//                                        CommodityWarehouseDTO commodityWarehouseDTO = CommodityWarehouseDTO.builder()
//                                                .id(listFindByTwoId.getId())
//                                                .idWarehouse(listFindByTwoId.getIdWarehouse())
//                                                .idCommodity(listFindByTwoId.getIdCommodity())
//                                                .inventoryNumber(sT)
//                                                .build();
//                                        commodityWarehouseService.save(commodityWarehouseDTO);
//                                    }
//                                    break outerLoop;
//                                }
//                                if (commodityWarehouseEntities.size() == 0) {
//                                    CommodityWarehouseDTO commodityWarehouseDTO = CommodityWarehouseDTO.builder()
//                                            .idWarehouse(warehouseEntityDTO.getIdWarehouse().toString())
//                                            .idCommodity(lstCommodity.getIdCommodity().toString())
//                                            .inventoryNumber(lstCommodityReceipt.getQuantity())
//                                            .build();
//                                    commodityWarehouseService.save(commodityWarehouseDTO);
//                                    break outerLoop;
//                                }
//                            }
//                        }
//                    }
//                }
//
//
//            return ResponseEntity.ok().body(iExportEntityNew);
//
//        } else {
//            List<WarehouseEntityDTO> listWarehouse = warehouseService.findAllWarehouse();
//            List<WarehouseEntityDTO> recommendWarehouse = new ArrayList<>();
//            for (WarehouseEntityDTO lst : listWarehouse) {
//                if (lst.getCapacity() > Mass) {
//                    recommendWarehouse.add(lst);
//                }
//            }
//
//            return ResponseEntity.ok().body(recommendWarehouse);
//        }
//    }

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
