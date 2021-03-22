package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.mini_project.CoreModule.entity.DocumentEntity;

import java.util.List;

public interface ItemReceiptMapper {
    List<DocumentEntity> itemReceiptToDocumentEntity(List<ItemReceiptDTO> itemReceiptDTOList);
}
