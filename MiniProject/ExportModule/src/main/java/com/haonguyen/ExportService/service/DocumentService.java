package com.haonguyen.ExportService.service;


import com.haonguyen.ExportService.dto.*;
import com.haonguyen.ExportService.dto.excel.ExcelDocumentDTO;
import com.haonguyen.ExportService.mapper.IDocumentMapper;
import com.haonguyen.ExportService.repository.IDocumentRepository;
import com.mini_project.CoreModule.entity.DocumentEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /**
     * Save vào bảng DocumentEntity
     * @param documentEntity
     * @return DocumentDTO chứa thông tin vừa lưu vào csdl;
     */
    public DocumentDTO addExport(DocumentEntity documentEntity){
        return iDocumentMapper.toDocumentDTO(iDocumentRepository.save(documentEntity));
    }

    /**
     * Lấy thông tin trong danh sách hồ sơ và insert vào CSDL
     * @param insertDataExportDTO
     * @return Danh sách document đã lưu
     */
    @Override
    public List<DocumentDTO> infoDocument(InsertDataExportDTO insertDataExportDTO) {
        List<DocumentDTO> documentDTO = new ArrayList<>();
        for(DocumentDTO temp: insertDataExportDTO.getDocumentDTOList()){
            documentDTO
                    .add(addExport(DocumentEntity
                            .builder()
                            .idImportExport(insertDataExportDTO.getId())
                            .imageUrl(temp.getImageUrl())
                            .build()));
        }
        return documentDTO;
    }
    @Override
    public List<ExcelDocumentDTO> toExcelDocumentDTOMapper(List<DocumentEntity> documentEntity){
        return iDocumentMapper.toExcelDocumentDTOs(documentEntity);
    }

    @Override
    public List<ExcelDocumentDTO> findByIdImportExport(UUID idImportExport) {
        List<DocumentEntity> documentEntities = iDocumentRepository.findByIdImportExport(idImportExport);
        return iDocumentMapper.toExcelDocumentDTOs(documentEntities);
    }
}
