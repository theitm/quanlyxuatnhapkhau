package com.haonguyen.ExportService.service;


import com.haonguyen.ExportService.dto.DocumentDTO;
import com.haonguyen.ExportService.dto.ExcelDocumentDTO;
import com.haonguyen.ExportService.dto.ExcelExportDTO;
import com.haonguyen.ExportService.dto.FormInsertDataExport;
import com.haonguyen.ExportService.mapper.IDocumentMapper;
import com.haonguyen.ExportService.repository.IDocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DocumentService implements IDocumentService {

    private final IDocumentMapper iDocumentMapper;
    private final IDocumentRepository iDocumentRepository;

    public DocumentService(IDocumentMapper iDocumentMapper, IDocumentRepository iDocumentRepository) {
        this.iDocumentMapper = iDocumentMapper;
        this.iDocumentRepository = iDocumentRepository;
    }

    @Override
    public ExcelDocumentDTO findDocumentByIdExport(UUID idExport) {
        return iDocumentMapper.toExcelDocumentDTO(iDocumentRepository.getByIdImportExport(idExport));
    }

    @Override
    public List<ExcelDocumentDTO> findAllDocumentByIdExport(UUID idExport) {
        return iDocumentMapper.toExcelDocumentDTOs(iDocumentRepository.findByIdImportExport(idExport));
    }

    @Override
    public List<DocumentDTO> addDocument(FormInsertDataExport formInsertDataExport) {
        return null;
    }
}
