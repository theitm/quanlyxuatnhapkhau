package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.repository.DocumentRepository;
import com.haonguyen.ServiceImport.service.DocumentService;
import com.mini_project.CoreModule.entity.DocumentEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public void save(List<DocumentEntity> documentEntityList, ImportExportEntity iExportEntityNew) {
        for (DocumentEntity listDocument: documentEntityList){
            listDocument.setIdImportExport(iExportEntityNew.getId());
            documentRepository.save(listDocument);
        }
    }

    @Override
    public void setInfoDocument(ImportExportEntity iExportEntity, List<DocumentEntity> documentEntityList) {
        for (DocumentEntity listDocument: documentEntityList){
            listDocument.setImportExportEntity(iExportEntity);
            listDocument.setIdImportExport(listDocument.getImportExportEntity().getId());
        }
    }
}
