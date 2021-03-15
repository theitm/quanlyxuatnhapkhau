package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.mini_project.Coremodule.entity.DetailsImport_ExportEntity;
import com.mini_project.Coremodule.entity.Import_ExportEntity;
import org.mapstruct.Mapper;



import java.util.List;

@Mapper
public interface ImportReceiptMapper {
    Import_ExportEntity importReceiptDTOToi_exportEntity(ImportReceiptDTO importReceiptDTO);
    List<DetailsImport_ExportEntity> importReceiptDTOToDetailsEntity(ImportReceiptDTO importReceiptDTO);
}