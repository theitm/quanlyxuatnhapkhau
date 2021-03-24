package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.CustomErrorMessage.ReceiptImportNotFoundException;
import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.mapper.ImportExportMapper;
import com.haonguyen.ServiceImport.mapper.ImportExportMapperImpl;
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
    public ImportExportEntity saveImportExportEntity(ImportExportEntity iExportEntity, ImportReceiptDTO importReceiptDTO) throws SaveException {
        ImportExportMapper importExportMapper = new ImportExportMapperImpl();
        ImportExportEntity importExportEntity = importExportMapper.importReceiptDTOToImportExportEntity(importReceiptDTO);
        ImportExportEntity importExportEntityNew = importExportRepository.save(importExportEntity);
        if(importExportEntity == null){
            throw new SaveException("Save Error Please Try Again");
        }
        iExportEntity.setId(importExportEntityNew.getId());
        return iExportEntity;
    }

    @Override
    public List<ImportExportEntity> getAllReceipt() {
        return importExportRepository.findAll();
    }

    @Override
    public ImportExportEntity getByIdImportExport(UUID idImportExport) throws ReceiptImportNotFoundException{

        ImportExportEntity importExportEntity = importExportRepository.findById(idImportExport).orElse(null);
        if(importExportEntity == null){
            throw new ReceiptImportNotFoundException("Not found id:" + idImportExport.toString());
        }
        return importExportEntity;
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
    public List<WarehouseEntity> findAllWarehouse() {

        return importExportRepository.findAllWarehouse();
    }

    @Override
    public List<ImportExportEntity> findAllByDate(Date date) {
        return importExportRepository.findAllByDate(date);
    }

    @Override
    public List<WarehouseCommodityEntity> findWarehouseCommodityByIdWarehouseIdCommodity(UUID idWarehouse, UUID idCommodity) {
        return importExportRepository.findWarehouseCommodityByIdWarehouseIdCommodity(idWarehouse, idCommodity);
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
