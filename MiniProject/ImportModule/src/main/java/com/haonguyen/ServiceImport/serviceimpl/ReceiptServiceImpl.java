package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
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

    /**
     * method to save Receipt Import
     *
     * @param importReceiptDTO
     * @return iExportEntityNew if Max(amount in receipt) < warehouse capacity
     * recommendWarehouse if Max > warehouse capacity
     */
    @Override
    public ResponseEntity getReceipt(ImportReceiptDTO importReceiptDTO) throws SaveException {
        if (importReceiptDTO == null) {
            return null;
        }

        List<ItemReceiptDTO> itemReceiptDTOList = importReceiptDTO.getItem();

        ImportExportMapper importExportMapper = new ImportExportMapperImpl();

        ItemReceiptMapper itemReceiptMapper = new ItemReceiptMapperImpl();

        DetailsImportExportMapper detailsImportExportMapper = new DetailsImportExportMapperImpl();

        CountryEntity countryEntity = importExportService.findCountryById(importReceiptDTO.getIdCountry());

        WarehouseEntity warehouseEntity = importExportService.findWarehouseById(importReceiptDTO.getIdWarehouse());

        ImportExportEntity importExportEntity = importExportMapper.importReceiptDTOToImportExportEntity(importReceiptDTO);

        List<DocumentEntity> documentEntityList = itemReceiptMapper.itemReceiptToDocumentEntity(importReceiptDTO.getItem());

        List<DetailsImportExportEntity> detailsIExportEntityList = detailsImportExportMapper.importReceiptDTOToDetailsEntity(importReceiptDTO.getItem());

        List<CommodityEntity> commodityEntityList = new ArrayList<>();

        int Max = 0;

        // get all the information commodity and Max
        for (ItemReceiptDTO listItem : itemReceiptDTOList) {
            CommodityEntity commodityEntity = getCommodityEntityFromCommodityModule(listItem);
            Max += listItem.getQuantity();
            commodityEntityList.add(commodityEntity);
        }

        documentService.setInfoDocument(importExportEntity, documentEntityList);

        if (Max < warehouseEntity.getCapacity()) {
            detailsImportExportService.setInfoDetailsImportExport(importExportEntity, detailsIExportEntityList, commodityEntityList);

            importExportService.setInfoImportExport(countryEntity, warehouseEntity, importExportEntity, documentEntityList, detailsIExportEntityList);

            ImportExportEntity importExportEntityNew = importExportService.saveImportExportEntity(importExportEntity, importReceiptDTO);
            detailsImportExportService.save(detailsIExportEntityList, importExportEntityNew);
            documentService.save(documentEntityList, importExportEntityNew);

            // create warehouseCommodityDTO
            WarehouseCommodityMapper warehouseCommodityMapper = new WarehouseCommodityMapperImpl();
            WarehouseCommodityDTO warehouseCommodityDTO = warehouseCommodityMapper.ToWarehouseCommodityDto(importExportEntity, importReceiptDTO);

            List<WarehouseCommodityEntity> warehouseCommodityEntityList = warehouseCommodityService.getFromWarehouseCommodityDTO(warehouseCommodityDTO);

            warehouseCommodityService.save(warehouseCommodityEntityList, importExportEntityNew);

            return ResponseEntity.ok().body(importExportEntity);
        } else {
            List<WarehouseEntity> recommendWarehouse = importExportService.getWarehouseEntityList(Max);
            return ResponseEntity.ok().body(recommendWarehouse);
        }
    }

    /**
     * method get CommodityEntity from CommodityModule
     *
     * @param listItemDto
     * @return commodityEntity
     */
    @Override
    public CommodityEntity getCommodityEntityFromCommodityModule(ItemReceiptDTO listItemDto) {
        String sourceCommodityURL = "http://COMMODITY-SERVICE/v1/api/commodity/";
        CommodityDTO resultCommodityDto = restTemplate.getForObject(sourceCommodityURL + listItemDto.getIdCommodity(), CommodityDTO.class);
        CommodityDTOMapper commodityDTOMapper = new CommodityDTOMapperImpl();
        CommodityEntity commodityEntity = commodityDTOMapper.toCommodityEntity(resultCommodityDto);
        return commodityEntity;
    }

    /**
     * method search Receipt ImportExportEntity
     *
     * @param keySearchDTO
     * @return iExportEntityList
     * @throws ParseException
     */
    @Override
    public List<ImportExportEntity> searchReceiptImportExport(KeySearchDTO keySearchDTO) throws ParseException {
        List<ImportExportEntity> iExportEntityList = new ArrayList<>();

        if (keySearchDTO.getDate() != null) {
            if (keySearchDTO.getKey() == null) {
                iExportEntityList.addAll(importExportService.findAllByDate(keySearchDTO.getDate()));
            } else {
                iExportEntityList.addAll(importExportService.searchImportExport(keySearchDTO.getKey(), keySearchDTO.getDate()));
            }
        } else {
            iExportEntityList.addAll(importExportService.searchImportExport(keySearchDTO.getKey(), keySearchDTO.getDate()));
        }
        return iExportEntityList;
    }
}