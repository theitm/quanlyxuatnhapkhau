package com.haonguyen.ExportService.mapper;


import com.haonguyen.ExportService.dto.DocumentDTO;
import com.haonguyen.ExportService.dto.excel.ExcelDocumentDTO;
import com.mini_project.CoreModule.entity.DocumentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDocumentMapper {

    ExcelDocumentDTO toExcelDocumentDTO(DocumentEntity documentEntity);
    List<ExcelDocumentDTO> toExcelDocumentDTOs(List<DocumentEntity> documentEntities);

    DocumentDTO toDocumentDTO(DocumentEntity documentEntity);
    List<DocumentDTO> toDocumentDTOs(List<DocumentEntity> documentEntities);


}
