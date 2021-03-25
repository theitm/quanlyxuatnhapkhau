package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.CustomErrorMessage.CommodityException;
import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
import com.haonguyen.ServiceImport.dto.*;
import com.haonguyen.ServiceImport.mapper.*;
import com.haonguyen.ServiceImport.service.*;
import com.mini_project.CoreModule.entity.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private final ImportExportService importExportService;
    private final WarehouseCommodityService warehouseCommodityService;
    private final DetailsImportExportService detailsImportExportService;
    private final DocumentService documentService;
    private final RestTemplate restTemplate;
    private final ItemReceiptMapper itemReceiptMapper;
    private final ImportExportMapper importExportMapper;
    private final DetailsImportExportMapper detailsImportExportMapper;
    private final WarehouseCommodityMapper warehouseCommodityMapper;
    private final CommodityDTOMapper commodityDTOMapper;

    public ReceiptServiceImpl(ImportExportService importExportService, WarehouseCommodityService warehouseCommodityService,
                              DetailsImportExportService detailsImportExportService,
                              DocumentService documentService, RestTemplate restTemplate, ItemReceiptMapper itemReceiptMapper,
                              ImportExportMapper importExportMapper, DetailsImportExportMapper detailsImportExportMapper,
                              WarehouseCommodityMapper warehouseCommodityMapper, CommodityDTOMapper commodityDTOMapper) {
        this.importExportService = importExportService;
        this.warehouseCommodityService = warehouseCommodityService;
        this.detailsImportExportService = detailsImportExportService;
        this.documentService = documentService;
        this.restTemplate = restTemplate;
        this.itemReceiptMapper = itemReceiptMapper;
        this.importExportMapper = importExportMapper;
        this.detailsImportExportMapper = detailsImportExportMapper;
        this.warehouseCommodityMapper = warehouseCommodityMapper;
        this.commodityDTOMapper = commodityDTOMapper;
    }

    /**
     * method to save Receipt Import
     *
     * @param importReceiptDTO
     * @return iExportEntityNew if Max(amount in receipt) < warehouse capacity
     * recommendWarehouse if Max > warehouse capacity
     */
    @Override
    public ResponseEntity getReceipt(ImportReceiptDTO importReceiptDTO) throws SaveException, CommodityException {
        if (importReceiptDTO == null) {
            return null;
        }

        List<ItemReceiptDTO> itemReceiptDTOList = importReceiptDTO.getItem();

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
    public CommodityEntity getCommodityEntityFromCommodityModule(ItemReceiptDTO listItemDto) throws CommodityException {
        try {
            String sourceCommodityURL = "http://COMMODITY-SERVICE/v1/api/commodity/";
            CommodityDTO resultCommodityDto = restTemplate.getForObject(sourceCommodityURL + listItemDto.getIdCommodity(), CommodityDTO.class);
            CommodityEntity commodityEntity = commodityDTOMapper.toCommodityEntity(resultCommodityDto);
            return commodityEntity;
        } catch (Exception exception) {
            throw new CommodityException("No response from CommodityService please try again later");
        }
    }

    /**
     * method search Receipt ImportExportEntity
     *
     * @param keySearchDTO
     * @return iExportEntityList
     * @throws ParseException
     */
    @Override
    public List<ImportExportEntity> searchReceiptImportExport(KeySearchDTO keySearchDTO) throws Exception {
        try {
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
        } catch (Exception exception) {
            throw new Exception();
        }
    }
}