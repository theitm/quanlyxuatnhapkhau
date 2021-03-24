package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.ItemReceiptDTO;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DetailsImportExportMapper {
    List<DetailsImportExportEntity> importReceiptDTOToDetailsEntity(List<ItemReceiptDTO> itemReceiptDTOList);
}
