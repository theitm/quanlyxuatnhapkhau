package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.repository.IexportRepository;
import com.haonguyen.ServiceImport.service.IexportService;
import com.mini_project.CoreModule.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ImportExportServiceImpl implements IexportService {

    public ImportExportServiceImpl(){};

    @Autowired
    private IexportRepository iexportRepository;
    @Autowired
    private IexportService iexportService;

    @Override
    public ImportExportEntity saveI_export(ImportExportEntity iExportEntity) {
        return iexportRepository.save(iExportEntity);
    }

    @Override
    public List<ImportExportEntity> getAllReceipt(){
        return iexportRepository.findAll();
    }

    @Override
    public ImportExportEntity getByIdI_Export(UUID idI_Export){
        return iexportRepository.findById(idI_Export).get();
    }

    @Override
    public void deleteById(UUID idI_Export){
        iexportRepository.deleteById(idI_Export);
    }

    @Override
    public List<ImportExportEntity> searchI_export(String key, Date date) {
        if(key != null){
        return iexportRepository.searchI_exportQueryIgnoreCase(key, date);
        }
        return iexportRepository.findAll();
    }

    @Override
    public WarehouseEntity findWarehouseById(UUID id) {
        return iexportRepository.findByIdWarehouse(id);
    }

    @Override
    public CountryEntity findCountryById(UUID id) {
        return iexportRepository.findByIdCountry(id);
    }

    @Override
    public CommodityEntity findCommodityById(UUID id) {

        return iexportRepository.findByIdCommodity(id);
    }

    @Override
    public List<WarehouseEntity> findAllWarehouse() {

        return iexportRepository.findAllWarehouse();
    }

    @Override
    public List<ImportExportEntity> findAllByDate(Date date) {
        return iexportRepository.findAllByDate(date);
    }

    @Override
    public List<WarehouseCommodityEntity> findWarehouseCommodityByTwoId(UUID idWarehouse, UUID idCommodity) {
        return iexportRepository.findWarehouseCommodityByIdImportExport(idWarehouse , idCommodity);
    }

    @Override
    public List<WarehouseEntity> getWarehouseEntityList(int Max) {
        List<WarehouseEntity> warehouseEntityList = iexportService.findAllWarehouse();
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
