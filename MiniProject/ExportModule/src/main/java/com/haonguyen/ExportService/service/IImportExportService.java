package com.haonguyen.ExportService.service;

import com.haonguyen.ExportService.dto.ExportFindByIdDTO;
import com.haonguyen.ExportService.dto.InsertDataExportDTO;
import com.haonguyen.ExportService.dto.ShowAddExportDTO;
import com.haonguyen.ExportService.dto.excel.ExcelExportDTO;
import com.haonguyen.ExportService.dto.excel.ReturnInfoExportAPI;
import com.mini_project.CoreModule.entity.ImportExportEntity;

import java.util.List;
import java.util.UUID;

public interface IImportExportService {

    List<ImportExportEntity> getExport();

    List<ImportExportEntity> getExportByCountryId(UUID id);

    ImportExportEntity updateExport(ImportExportEntity importExportEntity);

    ExportFindByIdDTO findByIdExport(UUID idExport);

    ImportExportEntity findByIdExportExcel(UUID idExport);

    List<ExcelExportDTO> findAllExport();

    ShowAddExportDTO infoExport(InsertDataExportDTO insertDataExportDTO);


    List<ReturnInfoExportAPI> getExcel(String monthAndYear);
}
