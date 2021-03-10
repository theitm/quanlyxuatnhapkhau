package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.entity.I_exportEntity;
import com.haonguyen.ServiceImport.repository.IexportRepository;
import com.haonguyen.ServiceImport.service.IexportService;
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
        return iexportRepository.searchI_exportQuery(key);
        }
        return iexportRepository.findAll();
    }
}
