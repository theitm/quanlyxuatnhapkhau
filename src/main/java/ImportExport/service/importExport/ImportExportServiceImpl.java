package ImportExport.service.importExport;

import ImportExport.dto.importExport.ImportExportCreateDto;
import ImportExport.dto.importExport.ImportExportDetailDto;
import ImportExport.entity.ImportExportEntity;
import ImportExport.mapper.ImportExportMapper;
import ImportExport.repository.ImportExportRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ImportExportServiceImpl implements ImportExportService {
    private final ImportExportRepository importExportRepository;
    private final ImportExportMapper importExportMapper;

    public ImportExportServiceImpl(ImportExportRepository importExportRepository, ImportExportMapper importExportMapper) {
        this.importExportRepository = importExportRepository;
        this.importExportMapper = importExportMapper;
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


}

