package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.dto.DocumentDTO;
import com.haonguyen.ExportService.dto.excel.ExcelDocumentDTO;
import com.haonguyen.ExportService.dto.FormInsertDataExport;
import com.mini_project.CoreModule.entity.DocumentEntity;

import java.util.List;
import java.util.UUID;

public interface IDocumentService {

    ExcelDocumentDTO findDocumentByIdExport(UUID idExport);

    List<ExcelDocumentDTO> findAllDocumentByIdExport(UUID idExport);

    List<DocumentDTO> infoDocument(FormInsertDataExport formInsertDataExport);

    List<ExcelDocumentDTO> toExcelDocumentDTOMapper(List<DocumentEntity> documentEntity);

    List<ExcelDocumentDTO> findByIdImportExport(UUID idImportExport);
}
