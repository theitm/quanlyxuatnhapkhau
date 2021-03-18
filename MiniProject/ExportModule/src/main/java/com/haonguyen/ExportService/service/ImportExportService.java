package com.haonguyen.ExportService.service;


import com.haonguyen.ExportService.repository.IImportExportRepository;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ImportExportService implements IImportExportService {

    private IImportExportRepository iImportExportRepository;

    public ImportExportService(IImportExportRepository iImportExportRepository) {
        this.iImportExportRepository = iImportExportRepository;
    }

    @Override
    public List<ImportExportEntity> getExport() {
        return iImportExportRepository.findAll();
    }

    @Override
    public List<ImportExportEntity> getExportByCountryId(UUID countryId) {
        return iImportExportRepository.getExportByCountry(countryId);
    }

    @Override
    public ImportExportEntity updateExport(ImportExportEntity importExportEntity) {
        return iImportExportRepository.save(importExportEntity);
    }
}
