package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.dto.DetailsExportDTO;
import com.haonguyen.ExportService.dto.FormInsertDataExport;

import java.util.List;
import java.util.UUID;

public interface IDetailsImportExportService {
    List<DetailsExportDTO> infoDetailsExport(FormInsertDataExport formInsertDataExport);
    Boolean checkIdCommodity(UUID idCommodity);
}
