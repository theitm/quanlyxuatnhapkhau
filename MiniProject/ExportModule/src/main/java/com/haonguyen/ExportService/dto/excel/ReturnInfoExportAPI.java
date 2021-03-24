package com.haonguyen.ExportService.dto.excel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReturnInfoExportAPI {
    private ExcelExportDTO excelExportDTO;
    private List<ExcelDocumentDTO> excelDocumentDTOS;
    private List<ExcelDetailsExportDTO> excelDetailsExportDTOS;
}
