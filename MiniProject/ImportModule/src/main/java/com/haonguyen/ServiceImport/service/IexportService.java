package com.haonguyen.ServiceImport.service;

import com.haonguyen.ServiceImport.entity.I_exportEntity;

import java.util.List;
import java.util.UUID;


public interface IexportService {

    I_exportEntity saveI_export(I_exportEntity iExportEntity);

    public List<I_exportEntity> getAllReceipt();

    List<I_exportEntity> getByIdI_Export(UUID idI_Export);

    void deleteById(UUID idI_Export);

    List<I_exportEntity> searchI_export(String key);

}
