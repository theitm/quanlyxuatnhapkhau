package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImportExportMapper {
    ImportExportEntity importReceiptDTOToImportExportEntity(ImportReceiptDTO importReceiptDTO);


}
