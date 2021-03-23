package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.dto.*;
import com.haonguyen.ServiceImport.mapper.*;
import com.haonguyen.ServiceImport.service.*;
import com.mini_project.CoreModule.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    private ImportExportService importExportService;
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

        CountryEntity countryEntity = importExportService.findCountryById(importReceiptDTO.getIdCountry());

        WarehouseEntity warehouseEntity = importExportService.findWarehouseById(importReceiptDTO.getIdWarehouse());

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

            importExportService.setInfoImportExport(countryEntity, warehouseEntity, iExportEntity, documentEntityList, detailsIExportEntityList);

            ImportExportEntity iExportEntityNew = importExportService.saveI_export(iExportEntity, importReceiptDTO);
            detailsImportExportService.save(detailsIExportEntityList, iExportEntityNew);
            documentService.save(documentEntityList, iExportEntityNew);

            WarehouseCommodityMapper warehouseCommodityMapper = new WarehouseCommodityMapperImpl();
            WarehouseCommodityDTO warehouseCommodityDTO = warehouseCommodityMapper.ToWarehouseCommodityDto(iExportEntityNew, importReceiptDTO);

            List<WarehouseCommodityEntity> warehouseCommodityEntityList = warehouseCommodityService.getFromWarehouseCommodityDTO(warehouseCommodityDTO);

            warehouseCommodityService.save(warehouseCommodityEntityList, iExportEntityNew);


            return ResponseEntity.ok().body(iExportEntityNew);
        } else {
            List<WarehouseEntity> recommendWarehouse = importExportService.getWarehouseEntityList(Max);
            return ResponseEntity.ok().body(recommendWarehouse);
        }
    }

    @Override
    public CommodityEntity getCommodityEntityFromCommodityDto(ItemReceiptDTO list) {
        String sourceCommodityURL = "http://COMMODITY-SERVICE/v1/api/commodity/getId/";
        CommodityDTO resultCommodityDto = restTemplate.getForObject(sourceCommodityURL + list.getIdCommodity(), CommodityDTO.class);
        CommodityDTOMapper commodityDTOMapper = new CommodityDTOMapperImpl();
        CommodityEntity commodityEntity = commodityDTOMapper.toCommodityEntity(resultCommodityDto);
        return commodityEntity;
    }

    @Override
    public List<ImportExportEntity> searchReceiptImportExport(KeySearchDTO keySearchDTO) throws ParseException {
        List<ImportExportEntity> iExportEntityList = new ArrayList<>();

        if (keySearchDTO.getDate() != null) {
            if (keySearchDTO.getKey() == null) {
                iExportEntityList.addAll(importExportService.findAllByDate(keySearchDTO.getDate()));
            } else {
                iExportEntityList.addAll(importExportService.searchImportExport(keySearchDTO.getKey(), keySearchDTO.getDate()));
            }
        }
        return iExportEntityList;
    }
}