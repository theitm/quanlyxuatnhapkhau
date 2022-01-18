package ImportExport.service.detailsImportExport;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;
import ImportExport.entity.DetailsImportExportEntity;
import ImportExport.mapper.DetailsImportExportMapper;
import ImportExport.repository.DetailsImportExportRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class DetailsImportExportServiceImpl implements DetailsImportExportService {
    private final DetailsImportExportRepository detailsImportExportRepository;
    private final DetailsImportExportMapper detailsImportExportMapper;

    public DetailsImportExportServiceImpl(DetailsImportExportRepository detailsImportExportRepository, DetailsImportExportMapper detailsImportExportMapper) {
        this.detailsImportExportRepository = detailsImportExportRepository;
        this.detailsImportExportMapper = detailsImportExportMapper;
    }

    /**
     * Chi tiết xuất nhập hàng hóa theo ID
     * @param id
     * @return
     */
    public DetailsImportExportDto findById(UUID id) {
        DetailsImportExportDto detailsImportExportDto = detailsImportExportMapper.fromEntityToDto(detailsImportExportRepository.getById(id));
        return detailsImportExportDto;
    }


    /**
     * Danh sách chi tiết xuất nhập hàng hóa
     * @return
     */
    public List<DetailsImportExportDto> findAll() {
        return detailsImportExportMapper.fromListEntityToDto(detailsImportExportRepository.findAll());
    }

    /**
     * Tạo một chi tiết xuất nhập hàng hóa
     * @param detailsImportExportCreateDto
     * @return
     */
    public DetailsImportExportDto createDetailsImportExport(DetailsImportExportCreateDto detailsImportExportCreateDto) {
        DetailsImportExportEntity detailsImportExportEntity = detailsImportExportMapper.fromDetailsImportExportCreateDto(detailsImportExportCreateDto);
        DetailsImportExportEntity detailsImportExportEntityCreate = detailsImportExportRepository.save(detailsImportExportEntity);
        DetailsImportExportDto detailsImportExportDto = null;
        if(detailsImportExportEntityCreate != null) {
            detailsImportExportDto = detailsImportExportMapper.fromEntityToDto(detailsImportExportEntityCreate);
        }
        return detailsImportExportDto;
    }


    /**
     * Cập nhật chi tiết hàng hóa
     * @param id
     * @param detailsImportExportCreateDto
     * @return
     */
    public DetailsImportExportDto updateDetailsImportExport(UUID id, DetailsImportExportCreateDto detailsImportExportCreateDto) {
        DetailsImportExportEntity detailsImportExportEntity = detailsImportExportMapper.fromDetailsImportExportCreateDto(detailsImportExportCreateDto);
        detailsImportExportEntity.setId(id);
        detailsImportExportRepository.save(detailsImportExportEntity);
        DetailsImportExportDto detailsImportExportDto = detailsImportExportMapper.fromEntityToDto(detailsImportExportEntity);
        return detailsImportExportDto;
    }

    /**
     * Xóa chi tiết xuất nhập hàng hóa theo ID
     * @param id
     */
    public void deleteById(UUID id) {
        detailsImportExportRepository.deleteById(id);
    }


}
