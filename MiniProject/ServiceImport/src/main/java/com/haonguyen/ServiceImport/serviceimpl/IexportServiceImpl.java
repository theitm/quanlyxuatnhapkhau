package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.repository.IexportRepository;
import com.haonguyen.ServiceImport.service.IexportService;
import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.CountryEntity;
import com.mini_project.Coremodule.entity.I_exportEntity;
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
    private IexportRepository iexportRepository;

    @Override
    public I_exportEntity saveI_export(I_exportEntity iExportEntity) {
        return iexportRepository.saveAndFlush(iExportEntity);
    }

    @Override
    public List<I_exportEntity> getAllReceipt(){
        return iexportRepository.findAll();
    }

    @Override
    public List<I_exportEntity> getByIdI_Export(UUID idI_Export){
        return iexportRepository.findAllById(Collections.singleton(idI_Export));
    }

    @Override
    public void deleteById(UUID idI_Export){
        iexportRepository.deleteById(idI_Export);
    }

    @Override
    public List<I_exportEntity> searchI_export(String key) {
        if(key != null){
        return iexportRepository.searchI_exportQueryIgnoreCase(key);
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
}
