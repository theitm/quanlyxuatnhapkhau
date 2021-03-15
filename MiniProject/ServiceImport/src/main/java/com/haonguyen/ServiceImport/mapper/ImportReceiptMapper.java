package com.haonguyen.ServiceImport.mapper;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.Coremodule.entity.DetailsI_exportEntity;
import com.mini_project.Coremodule.entity.I_exportEntity;
import org.mapstruct.Mapper;



import java.util.List;

@Mapper
public interface ImportReceiptMapper {
    I_exportEntity importReceiptDTOToi_exportEntity(ImportReceiptDTO importReceiptDTO);
    List<DetailsI_exportEntity> importReceiptDTOToDetailsEntity(ImportReceiptDTO importReceiptDTO);
}
