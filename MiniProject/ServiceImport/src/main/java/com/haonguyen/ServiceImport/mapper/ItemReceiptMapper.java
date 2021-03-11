package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.DocumentEntity;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ItemReceiptMapper {
    List<DocumentEntity> itemReceiptToDocumentEntity(List<ItemReceiptDTO> itemReceiptDTOList);
}
