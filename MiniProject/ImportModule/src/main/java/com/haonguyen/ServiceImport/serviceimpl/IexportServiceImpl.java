package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.repository.IImportExportRepository;
import com.haonguyen.ServiceImport.service.IexportService;
import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.CountryEntity;
import com.mini_project.Coremodule.entity.Import_ExportEntity;
import com.mini_project.Coremodule.entity.WarehouseEntity;
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
    public Import_ExportEntity saveI_export(Import_ExportEntity iExportEntity) {
        return IImportExportRepository.saveAndFlush(iExportEntity);
    }

    @Override
    public List<Import_ExportEntity> getAllReceipt(){
        return IImportExportRepository.findAll();
    }

    @Override
    public List<Import_ExportEntity> getByIdI_Export(UUID idI_Export){
        return IImportExportRepository.findAllById(Collections.singleton(idI_Export));
    }

    @Override
    public void deleteById(UUID idI_Export){
        IImportExportRepository.deleteById(idI_Export);
    }

    @Override
    public List<Import_ExportEntity> searchI_export(String key) {
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
