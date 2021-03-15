package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.mini_project.Coremodule.entity.DocumentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ItemReceiptMapper {
    List<DocumentEntity> itemReceiptToDocumentEntity(List<ItemReceiptDTO> itemReceiptDTOList);
}
