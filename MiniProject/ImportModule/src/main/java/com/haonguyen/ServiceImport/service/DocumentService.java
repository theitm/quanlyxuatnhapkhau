package com.haonguyen.ServiceImport.service;

import com.haonguyen.ServiceImport.entity.DocumentEntity;

import java.util.List;


public interface DocumentService {


    public DocumentEntity saveDocument(DocumentEntity documentEntity);

    public List<DocumentEntity> findDocumentByIdI_Export(String idI_Export);

    public List<String> findImageUrlById(String idI_Export);
}
