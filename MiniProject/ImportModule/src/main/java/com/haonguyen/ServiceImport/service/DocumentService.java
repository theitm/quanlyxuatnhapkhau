package com.haonguyen.ServiceImport.service;

import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
import com.mini_project.CoreModule.entity.DocumentEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;

import java.util.List;

public interface DocumentService {
    DocumentEntity save(List<DocumentEntity> documentEntityList, ImportExportEntity iExportEntityNew) throws SaveException;

    void setInfoDocument(ImportExportEntity iExportEntity, List<DocumentEntity> documentEntityList);
}
