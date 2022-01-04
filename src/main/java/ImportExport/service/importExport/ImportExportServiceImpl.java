package ImportExport.service.importExport;

import ImportExport.dto.importExport.ImportExportCreateDto;
import ImportExport.dto.importExport.ImportExportDetailDto;
import ImportExport.entity.ImportExportEntity;
import ImportExport.mapper.ImportExportMapper;
import ImportExport.repository.ImportExportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ImportExportServiceImpl implements ImportExportService {
    private final ImportExportRepository importExportRepository;
    private final ImportExportMapper importExportMapper;

    public ImportExportServiceImpl(ImportExportRepository importExportRepository, ImportExportMapper importExportMapper) {
        this.importExportRepository = importExportRepository;
        this.importExportMapper = importExportMapper;
    }
    public Optional<ImportExportEntity> findById(UUID id) {
        return importExportRepository.findById(id);
    }
    public ImportExportDetailDto createImportExport(ImportExportCreateDto importExportCreateDto) {
        ImportExportEntity importExportEntity = importExportMapper.fromImportExportCreateDto(importExportCreateDto);
        ImportExportEntity importExportEntityCreate = importExportRepository.save(importExportEntity);
        ImportExportDetailDto importExportDetailDto = null;
        if(importExportEntityCreate != null) {
            importExportDetailDto = importExportMapper.fromEntityToDto(importExportEntityCreate);
        }
        return importExportDetailDto;
    }


}

