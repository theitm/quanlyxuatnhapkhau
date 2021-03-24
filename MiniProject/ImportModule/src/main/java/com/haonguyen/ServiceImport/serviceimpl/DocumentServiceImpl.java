package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
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
    public DocumentEntity save(List<DocumentEntity> documentEntityList, ImportExportEntity iExportEntityNew) throws SaveException {
        DocumentEntity documentEntity = null;
        for (DocumentEntity listDocument: documentEntityList){
            listDocument.setIdImportExport(iExportEntityNew.getId());
           documentEntity = documentRepository.save(listDocument);
        }
        if(documentEntity == null){
            throw new SaveException("Save Error Please Try Again");
        }
        return documentEntity;
    }

    @Override
    public void setInfoDocument(ImportExportEntity iExportEntity, List<DocumentEntity> documentEntityList) {
        for (DocumentEntity listDocument: documentEntityList){
            listDocument.setImportExportEntity(iExportEntity);
            listDocument.setIdImportExport(listDocument.getImportExportEntity().getId());
        }
    }
}
