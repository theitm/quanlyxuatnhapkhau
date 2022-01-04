package ImportExport.service.detailsImportExport;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;
import ImportExport.entity.DetailsImportExportEntity;
import ImportExport.mapper.DetailsImportExportMapper;
import ImportExport.repository.DetailsImportExportRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service

public class DetailsImportExportServiceImpl implements DetailsImportExportService {
    private final DetailsImportExportRepository detailsImportExportRepository;
    private final DetailsImportExportMapper detailsImportExportMapper;

    public DetailsImportExportServiceImpl(DetailsImportExportRepository detailsImportExportRepository, DetailsImportExportMapper detailsImportExportMapper) {
        this.detailsImportExportRepository = detailsImportExportRepository;
        this.detailsImportExportMapper = detailsImportExportMapper;
    }
    public Optional<DetailsImportExportEntity> findById(UUID id) {
        return detailsImportExportRepository.findById(id);
    }
    public DetailsImportExportDto createDetailsImportExport(DetailsImportExportCreateDto detailsImportExportCreateDto) {
        DetailsImportExportEntity detailsImportExportEntity = detailsImportExportMapper.fromDetailsImportExportCreateDto(detailsImportExportCreateDto);
        DetailsImportExportEntity detailsImportExportEntityCreate = detailsImportExportRepository.save(detailsImportExportEntity);
        DetailsImportExportDto detailsImportExportDto = null;
        if(detailsImportExportEntityCreate != null) {
            detailsImportExportDto = detailsImportExportMapper.fromEntityToDto(detailsImportExportEntityCreate);
        }
        return detailsImportExportDto;
    }
}
