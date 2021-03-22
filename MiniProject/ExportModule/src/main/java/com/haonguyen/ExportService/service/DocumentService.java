package com.haonguyen.ExportService.service;


import com.haonguyen.ExportService.dto.*;
import com.haonguyen.ExportService.mapper.IDocumentMapper;
import com.haonguyen.ExportService.repository.IDocumentRepository;
import com.mini_project.CoreModule.entity.DocumentEntity;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

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
     * @param formInsertDataExport
     * @return Danh sách document đã lưu
     */
    @Override
    public List<DocumentDTO> infoDocument(FormInsertDataExport formInsertDataExport) {
        List<DocumentDTO> documentDTO = new ArrayList<>();
        for(DocumentDTO temp:formInsertDataExport.getDocumentDTOList()){
            documentDTO
                    .add(addExport(DocumentEntity
                            .builder()
                            .idImportExport(formInsertDataExport.getId())
                            .imageUrl(temp.getImageUrl())
                            .build()));
        }
        return documentDTO;
    }
}
