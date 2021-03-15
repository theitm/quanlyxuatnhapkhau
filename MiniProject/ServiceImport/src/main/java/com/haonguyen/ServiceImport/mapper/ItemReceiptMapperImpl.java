package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.haonguyen.ServiceImport.service.IexportService;
import com.haonguyen.ServiceImport.serviceimpl.IexportServiceImpl;
import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.DocumentEntity;
import com.mini_project.Coremodule.entity.I_exportEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
