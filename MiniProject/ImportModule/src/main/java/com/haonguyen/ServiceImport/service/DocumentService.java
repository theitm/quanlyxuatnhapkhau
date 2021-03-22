package com.haonguyen.ServiceImport.service;

import com.mini_project.CoreModule.entity.DocumentEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;

import java.util.List;

public interface DocumentService {
    void save(List<DocumentEntity> documentEntityList, ImportExportEntity iExportEntityNew);

    void setInfoDocument(ImportExportEntity iExportEntity, List<DocumentEntity> documentEntityList);
}
