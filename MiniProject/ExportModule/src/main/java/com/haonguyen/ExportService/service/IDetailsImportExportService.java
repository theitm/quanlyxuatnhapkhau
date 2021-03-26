package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.dto.DetailsExportDTO;
import com.haonguyen.ExportService.dto.InsertDataExportDTO;
import com.haonguyen.ExportService.dto.QuantityUsingInImport;
import com.haonguyen.ExportService.dto.SourceExportDTO;
import com.haonguyen.ExportService.dto.excel.ExcelDetailsExportDTO;

import java.util.List;
import java.util.UUID;

public interface IDetailsImportExportService {
    List<DetailsExportDTO> infoDetailsExport(InsertDataExportDTO insertDataExportDTO);
    Boolean checkIdCommodity(UUID idCommodity);

    List<ExcelDetailsExportDTO> findByIdImportExport(UUID idImportExport);

    List<SourceExportDTO> sourceExport(UUID idExport);

    List<DetailsExportDTO> findImportByIdCommodity(UUID idCommodity);

    QuantityUsingInImport getQuantityUsingInImport(UUID idRefExport);

}
