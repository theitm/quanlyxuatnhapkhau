package com.haonguyen.ExportService.service;

import com.mini_project.CoreModule.entity.ImportExportEntity;

import java.util.List;
import java.util.UUID;

public interface IImportExportService {
    List<ImportExportEntity> getExport();
    List<ImportExportEntity> getExportByCountryId(UUID id);

    ImportExportEntity updateExport(ImportExportEntity importExportEntity);
}
