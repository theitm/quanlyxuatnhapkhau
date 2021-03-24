package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.mapper.ImportReceiptMapper;
import com.haonguyen.ServiceImport.mapper.ImportReceiptMapperImpl;
import com.haonguyen.ServiceImport.repository.ImportExportRepository;
import com.haonguyen.ServiceImport.service.ImportExportService;
import com.mini_project.CoreModule.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ImportExportServiceImpl implements ImportExportService {

    public ImportExportServiceImpl() {
    }

    ;

    @Autowired
    private ImportExportRepository importExportRepository;
    @Autowired
    private ImportExportService importExportService;

    /**
     * method save importExportEntity mapper from ImportReceiptDTO set New id to iExportEntity
     *
     * @param iExportEntity
     * @param importReceiptDTO
     * @return iExportEntity set new idImportExport
     */
    @Override
    public ImportExportEntity saveImportExportEntity(ImportExportEntity iExportEntity, ImportReceiptDTO importReceiptDTO) {
        ImportReceiptMapper importReceiptMapper = new ImportReceiptMapperImpl();
        ImportExportEntity importExportEntity = importReceiptMapper.importReceiptDTOToi_exportEntity(importReceiptDTO);
        ImportExportEntity importExportEntityNew = importExportRepository.save(importExportEntity);
        iExportEntity.setId(importExportEntityNew.getId());
        return iExportEntity;
    }

    @Override
    public List<ImportExportEntity> getAllReceipt() {
        return importExportRepository.findAll();
    }

    @Override
    public ImportExportEntity getByIdI_Export(UUID idI_Export) {
        return importExportRepository.findById(idI_Export).get();
    }

    @Override
    public void deleteById(UUID idI_Export) {
        importExportRepository.deleteById(idI_Export);
    }

    @Override
    public List<ImportExportEntity> searchImportExport(String key, Date date) {
        return importExportRepository.searchImportExportQueryIgnoreCase(key, date);
    }

    @Override
    public WarehouseEntity findWarehouseById(UUID id) {
        return importExportRepository.findByIdWarehouse(id);
    }

    @Override
    public CountryEntity findCountryById(UUID id) {
        return importExportRepository.findByIdCountry(id);
    }

    @Override
    public CommodityEntity findCommodityById(UUID id) {

        return importExportRepository.findByIdCommodity(id);
    }

    @Override
    public List<WarehouseEntity> findAllWarehouse() {

        return importExportRepository.findAllWarehouse();
    }

    @Override
    public List<ImportExportEntity> findAllByDate(Date date) {
        return importExportRepository.findAllByDate(date);
    }

    @Override
    public List<WarehouseCommodityEntity> findWarehouseCommodityByTwoId(UUID idWarehouse, UUID idCommodity) {
        return importExportRepository.findWarehouseCommodityByIdImportExport(idWarehouse, idCommodity);
    }

    @Override
    public List<WarehouseEntity> getWarehouseEntityList(int Max) {
        List<WarehouseEntity> warehouseEntityList = importExportService.findAllWarehouse();
        List<WarehouseEntity> recommendWarehouse = new ArrayList<>();
        for (WarehouseEntity list : warehouseEntityList) {
            if (list.getCapacity() > Max)
                recommendWarehouse.add(list);
        }
        return recommendWarehouse;
    }

    @Override
    public void setInfoImportExport(CountryEntity countryEntity, WarehouseEntity warehouseEntity,
                                    ImportExportEntity iExportEntity,
                                    List<DocumentEntity> documentEntityList,
                                    List<DetailsImportExportEntity> detailsIExportEntityList) {
        iExportEntity.setCountryEntity(countryEntity);
        iExportEntity.setWarehouseEntity(warehouseEntity);
        iExportEntity.setDocumentEntities(documentEntityList);
        iExportEntity.setDetailsImportExportEntities(detailsIExportEntityList);
    }
}
