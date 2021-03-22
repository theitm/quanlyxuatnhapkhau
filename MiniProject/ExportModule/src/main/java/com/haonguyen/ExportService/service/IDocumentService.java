package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.dto.DocumentDTO;
import com.haonguyen.ExportService.dto.ExcelDocumentDTO;
import com.haonguyen.ExportService.dto.ExcelExportDTO;
import com.haonguyen.ExportService.dto.FormInsertDataExport;
import org.w3c.dom.Document;

import java.util.List;
import java.util.UUID;

public interface IDocumentService {

    ExcelDocumentDTO findDocumentByIdExport(UUID idExport);

    List<ExcelDocumentDTO> findAllDocumentByIdExport(UUID idExport);

    List<DocumentDTO> infoDocument(FormInsertDataExport formInsertDataExport);
}
