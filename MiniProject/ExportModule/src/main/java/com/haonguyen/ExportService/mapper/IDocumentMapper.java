package com.haonguyen.ExportService.mapper;


import com.haonguyen.ExportService.dto.ExcelDocumentDTO;
import com.haonguyen.ExportService.dto.ExcelExportDTO;
import com.mini_project.CoreModule.entity.DocumentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDocumentMapper {

    ExcelDocumentDTO toExcelDocumentDTO(DocumentEntity documentEntity);

    List<ExcelDocumentDTO> toExcelDocumentDTOs(List<DocumentEntity> documentEntities);
}
