package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.dto.ExcelDocumentDTO;
import com.haonguyen.ExportService.dto.ExcelExportDTO;

import java.util.List;
import java.util.UUID;

public interface IDocumentService {

    ExcelDocumentDTO findDocumentByIdExport(UUID idExport);

    List<ExcelDocumentDTO> findAllDocumentByIdExport(UUID idExport);
}
