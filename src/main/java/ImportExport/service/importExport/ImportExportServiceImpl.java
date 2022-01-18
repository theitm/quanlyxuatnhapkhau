package ImportExport.service.importExport;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.importExport.*;
import ImportExport.entity.ImportExportEntity;
import ImportExport.mapper.ImportExportMapper;
import ImportExport.repository.ImportExportRepository;
import ImportExport.service.detailsImportExport.DetailsImportExportService;
import ImportExport.service.document.DocumentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ImportExportServiceImpl implements ImportExportService {
    private final ImportExportRepository importExportRepository;
    private final ImportExportMapper importExportMapper;
    private final DetailsImportExportService detailsImportExportService;
    private final DocumentService documentService;

    public ImportExportServiceImpl(ImportExportRepository importExportRepository, ImportExportMapper importExportMapper, DetailsImportExportService detailsImportExportService, DocumentService documentService) {
        this.importExportRepository = importExportRepository;
        this.importExportMapper = importExportMapper;
        this.detailsImportExportService = detailsImportExportService;
        this.documentService = documentService;
    }

    /**
     * Hiện hàng xuất nhập theo ID
     * @param id
     * @return
     */
    public ImportExportDetailDto findById(UUID id) {
        ImportExportDetailDto importExportDetailDto = importExportMapper.fromEntityToDto(importExportRepository.getById(id));
        return importExportDetailDto;
    }

    /**
     * Hiện danh sách hàng xuất nhập
     * @return
     */
    public List<ImportExportDetailDto> findAll() {
        return importExportMapper.fromListEntityToDto(importExportRepository.findAll());
    }

    /**
     * Tạo một xuất nhập hàng hóa
     * @param importExportCreateDto
     * @return
     */
    public ImportExportDetailDto createImportExport(ImportExportCreateDto importExportCreateDto) {
        ImportExportEntity importExportEntity = importExportMapper.fromImportExportCreateDto(importExportCreateDto);
        ImportExportEntity importExportEntityCreate = importExportRepository.save(importExportEntity);
        ImportExportDetailDto importExportDetailDto = null;
        if(importExportEntityCreate != null) {
            importExportDetailDto = importExportMapper.fromEntityToDto(importExportEntityCreate);
        }
        return importExportDetailDto;
    }

    /**
     * Cập nhật xuất nhập hàng hóa
     * @param id
     * @param importExportCreateDto
     * @return
     */
    public ImportExportDetailDto updateImExPort(UUID id, ImportExportCreateDto importExportCreateDto) {
        ImportExportEntity importExportEntity = importExportMapper.fromImportExportCreateDto(importExportCreateDto);
        importExportEntity.setId(id);
        importExportRepository.save(importExportEntity);
        ImportExportDetailDto importExportDetailDto = importExportMapper.fromEntityToDto(importExportEntity);
        return importExportDetailDto;
    }

    /**
     * Xóa một xuất nhập hàng hóa theo ID
     * @param id
     */
    public void deleteById(UUID id) {
        importExportRepository.deleteById(id);
    }

    /**
     * ImportCommodity
     * @param importExportAddDto
     * @return
     */

    public ImportExportDto addIE(ImportExportAddDto importExportAddDto) {
        ImportExportEntity importExportEntity = importExportMapper.fromAddDtoToEntity(importExportAddDto);
        importExportEntity.setDetailsImportExports(null);
        importExportEntity.setDocuments(null);
        ImportExportEntity importExportCreatedEntity = importExportRepository.save(importExportEntity);
        for (DetailsImportExportCreateDto detailsImportExportCreateDto : importExportAddDto.getDetailsImportExports() ) {
            detailsImportExportCreateDto.setIdImportExport(importExportCreatedEntity.getId());
             detailsImportExportService.createDetailsImportExport(detailsImportExportCreateDto);
        }
        for (DocumentCreateDto documentCreateDto : importExportAddDto.getDocuments()) {
            documentCreateDto.setIdImportExport(importExportCreatedEntity.getId());
            documentService.createDocument(documentCreateDto);
        }
        return null;
    }
}

