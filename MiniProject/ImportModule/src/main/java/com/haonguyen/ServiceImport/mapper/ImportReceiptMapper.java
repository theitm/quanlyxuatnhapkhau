package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.mapstruct.Mapper;



import java.util.List;

@Mapper
public interface ImportReceiptMapper {
    ImportExportEntity importReceiptDTOToi_exportEntity(ImportReceiptDTO importReceiptDTO);
    List<DetailsImportExportEntity> importReceiptDTOToDetailsEntity(ImportReceiptDTO importReceiptDTO);
}
