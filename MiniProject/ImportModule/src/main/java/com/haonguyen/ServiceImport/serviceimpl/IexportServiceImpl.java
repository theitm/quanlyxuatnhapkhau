package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.repository.IImportExportRepository;
import com.haonguyen.ServiceImport.service.IexportService;
import com.mini_project.CoreModule.entity.CommodityEntity;
import com.mini_project.CoreModule.entity.CountryEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import com.mini_project.CoreModule.entity.WarehouseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class IexportServiceImpl implements IexportService {

    public IexportServiceImpl(){};

    @Autowired
    private IImportExportRepository IImportExportRepository;

    @Override
    public ImportExportEntity saveI_export(ImportExportEntity iExportEntity) {
        return IImportExportRepository.saveAndFlush(iExportEntity);
    }

    @Override
    public List<ImportExportEntity> getAllReceipt(){
        return IImportExportRepository.findAll();
    }

    @Override
    public List<ImportExportEntity> getByIdI_Export(UUID idI_Export){
        return IImportExportRepository.findAllById(Collections.singleton(idI_Export));
    }

    @Override
    public void deleteById(UUID idI_Export){
        IImportExportRepository.deleteById(idI_Export);
    }

    @Override
    public List<ImportExportEntity> searchI_export(String key) {
        if(key != null){
        return IImportExportRepository.searchI_exportQueryIgnoreCase(key);
        }
        return IImportExportRepository.findAll();
    }

    @Override
    public WarehouseEntity findWarehouseById(UUID id) {
        return IImportExportRepository.findByIdWarehouse(id);
    }

    @Override
    public CountryEntity findCountryById(UUID id) {
        return IImportExportRepository.findByIdCountry(id);
    }

    @Override
    public CommodityEntity findCommodityById(UUID id) {

        return IImportExportRepository.findByIdCommodity(id);
    }

    @Override
    public List<WarehouseEntity> findAllWarehouse() {

        return IImportExportRepository.findAllWarehouse();
    }
}
