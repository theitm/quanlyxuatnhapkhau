package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.mini_project.CoreModule.entity.DocumentEntity;

import java.util.ArrayList;
import java.util.List;

public class ItemReceiptMapperImpl implements ItemReceiptMapper{
    @Override
    public List<DocumentEntity> itemReceiptToDocumentEntity(List<ItemReceiptDTO> itemReceiptDTOList) {
        if(itemReceiptDTOList == null){
        return null;
        }
        List<DocumentEntity> documentEntityList = new ArrayList<>();

        for (ItemReceiptDTO list: itemReceiptDTOList){
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setImage_url(list.getImageUrl().toString());

        documentEntityList.add(documentEntity);
        }
        return documentEntityList;
    }


}
