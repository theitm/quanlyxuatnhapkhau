package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.dto.CommodityDTO;
import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.haonguyen.ServiceImport.dto.WarehouseCommodityDTO;
import com.haonguyen.ServiceImport.mapper.*;
import com.haonguyen.ServiceImport.service.*;
import com.mini_project.CoreModule.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    private IexportService iexportService;
    @Autowired
    private WarehouseCommodityService warehouseCommodityService;
    @Autowired
    private DetailsImportExportService detailsImportExportService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity getReceipt(ImportReceiptDTO importReceiptDTO) {
        if (importReceiptDTO == null) {
            return null;
        }

        List<ItemReceiptDTO> itemReceiptDTOList = importReceiptDTO.getItem();

        ImportReceiptMapper importReceiptMapper = new ImportReceiptMapperImpl();

        ItemReceiptMapper itemReceiptMapper = new ItemReceiptMapperImpl();

        CountryEntity countryEntity = iexportService.findCountryById(importReceiptDTO.getIdCountry());

        WarehouseEntity warehouseEntity = iexportService.findWarehouseById(importReceiptDTO.getIdWarehouse());

        ImportExportEntity iExportEntity = importReceiptMapper.importReceiptDTOToi_exportEntity(importReceiptDTO);

        List<DocumentEntity> documentEntityList = itemReceiptMapper.itemReceiptToDocumentEntity(importReceiptDTO.getItem());

        List<DetailsImportExportEntity> detailsIExportEntityList = importReceiptMapper.importReceiptDTOToDetailsEntity(importReceiptDTO);

        List<CommodityEntity> commodityEntityList = new ArrayList<>();

        int Max = 0;

        for (ItemReceiptDTO list : itemReceiptDTOList) {
            CommodityEntity commodityEntity = getCommodityEntityFromCommodityDto(list);
            Max += list.getQuantity();
            commodityEntityList.add(commodityEntity);
        }

        documentService.setInfoDocument(iExportEntity, documentEntityList);

        if (Max < warehouseEntity.getCapacity()) {
            detailsImportExportService.setInfoDetailsImportExport(iExportEntity, detailsIExportEntityList, commodityEntityList);

            iexportService.setInfoImportExport(countryEntity, warehouseEntity, iExportEntity, documentEntityList, detailsIExportEntityList);

            ImportExportEntity iExportEntityNew = iexportService.saveI_export(iExportEntity);
            detailsImportExportService.save(detailsIExportEntityList, iExportEntityNew);
            documentService.save(documentEntityList, iExportEntityNew);

            WarehouseCommodityMapper warehouseCommodityMapper = new WarehouseCommodityMapperImpl();
            WarehouseCommodityDTO warehouseCommodityDTO = warehouseCommodityMapper.ToWarehouseCommodityDto(iExportEntityNew, importReceiptDTO);

            List<WarehouseCommodityEntity> warehouseCommodityEntityList = warehouseCommodityService.getFromWarehouseCommodityDTO(warehouseCommodityDTO);

            warehouseCommodityService.save(warehouseCommodityEntityList, iExportEntityNew);


            return ResponseEntity.ok().body(iExportEntityNew);
        } else {
            List<WarehouseEntity> recommendWarehouse = iexportService.getWarehouseEntityList(Max);
            return ResponseEntity.ok().body(recommendWarehouse);
        }
    }

    @Override
    public CommodityEntity getCommodityEntityFromCommodityDto(ItemReceiptDTO list) {
        String sourceCommodityURL = "http://COMMODITY-SERVICE/commodity/getId/";
        CommodityDTO resultCommodityDto = restTemplate.getForObject(sourceCommodityURL + list.getIdCommodity(), CommodityDTO.class);
        CommodityDTOMapper commodityDTOMapper = new CommodityDTOMapperImpl();
        CommodityEntity commodityEntity = commodityDTOMapper.toCommodityEntity(resultCommodityDto);
        return commodityEntity;
    }

}
