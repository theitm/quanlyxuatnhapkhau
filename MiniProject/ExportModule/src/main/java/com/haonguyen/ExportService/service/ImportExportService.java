package com.haonguyen.ExportService.service;


import com.haonguyen.ExportService.dto.*;
import com.haonguyen.ExportService.mapper.IImportExportMapper;
import com.haonguyen.ExportService.repository.IImportExportRepository;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import java.util.List;
import java.util.UUID;

@Service
public class ImportExportService implements IImportExportService {

    private final IImportExportRepository iImportExportRepository;
    private final IImportExportMapper iImportExportMapper;
    private final IDocumentService iDocumentService;

    public ImportExportService(IImportExportRepository iImportExportRepository, IImportExportMapper iImportExportMapper,
                               IDocumentService iDocumentService) {
        this.iImportExportRepository = iImportExportRepository;
        this.iImportExportMapper = iImportExportMapper;
        this.iDocumentService = iDocumentService;
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

    @Override
    public ExportFindByIdDTO findByIdExport(UUID idExport) {
        return iImportExportMapper.toExportFindByIdDTO(iImportExportRepository.getById(idExport));
    }

    @Override
    public ImportExportEntity findByIdExportExcel(UUID idExport) {
        return iImportExportRepository.getById(idExport);
    }

    @Override
    public List<ExcelExportDTO> findAllExport() {
        return iImportExportMapper.toExcelExportDTOs(iImportExportRepository.findAll());
    }

    /**
     * Save vào bảng ImportExportEntity
     * @param importExportEntity
     * @return ExportDTO chứa dữ liệu map từ ImportExportEntity
     */
    public ExportDTO addExport(ImportExportEntity importExportEntity){
        return iImportExportMapper.toExportDTO(iImportExportRepository.save(importExportEntity));
    }


    @Override
    public ShowAddExportDTO addInfoExport(FormInsertDataExport formInsertDataExport) {
        ExportDTO exportDTO = addExport(ImportExportEntity
                .builder()
                .idCountry(formInsertDataExport.getCountryId())
                .idWarehouse(formInsertDataExport.getWarehouseId())
                .date(formInsertDataExport.getDate())
                .type(1)
                .build());

        return null;
    }
}
