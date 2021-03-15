package com.haonguyen.ServiceImport.serviceimpl;

import com.haonguyen.ServiceImport.entity.DocumentEntity;
import com.haonguyen.ServiceImport.repository.DocumentRepository;
import com.haonguyen.ServiceImport.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class DocumentServiceImpl implements DocumentService {

    public DocumentServiceImpl(){};

    @Autowired
    private DocumentRepository documentRepository;

    public DocumentEntity saveDocument(DocumentEntity documentEntity) {
        return documentRepository.save(documentEntity);
    }

    public List<DocumentEntity> findDocumentByIdI_Export(String idI_Export){
        return Arrays.asList(documentRepository.findById(UUID.fromString(idI_Export)).get());
    }

    public List<String> findImageUrlById(String idI_Export){
        return documentRepository.findImageUrlByIdQuery(idI_Export);
    }
}
