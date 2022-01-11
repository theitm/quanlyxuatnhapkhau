package ImportExport.service.embargo;

import ImportExport.dto.embargo.EmbargoCreateDto;
import ImportExport.dto.embargo.EmbargoDetailDto;
import ImportExport.entity.EmbargoEntity;
import ImportExport.mapper.EmbargoMapper;
import ImportExport.repository.EmbargoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class EmbargoServiceImpl implements EmbargoService {
    private final EmbargoRepository embargoRepository;
    private final EmbargoMapper embargoMapper;

    public EmbargoServiceImpl(EmbargoRepository embargoRepository, EmbargoMapper embargoMapper) {
        this.embargoRepository = embargoRepository;
        this.embargoMapper = embargoMapper;
    }

    /**
     * Tìm loại hàng cấm vận ID
     * @param id
     * @return
     */
    public EmbargoDetailDto findById(UUID id) {
        EmbargoDetailDto embargoDetailDto = embargoMapper.fromEntityToDto(embargoRepository.getById(id));
        return embargoDetailDto;
    }

    /**
     * Danh sách loại hàng bị cấm vận
     * @return
     */
    public List<EmbargoDetailDto> findAll() {
        return embargoMapper.fromListEntityToDto(embargoRepository.findAll());
    }

    /**
     * Tạo một cấm vận theo loại hàng
     * @param embargoCreateDto
     * @return
     */
    public EmbargoDetailDto createEmbargo(EmbargoCreateDto embargoCreateDto) {
        EmbargoEntity embargoEntity = embargoMapper.fromEmbargoCreateDto(embargoCreateDto);
        EmbargoEntity embargoEntityCreate = embargoRepository.save(embargoEntity);
        EmbargoDetailDto embargoDetailDto = null;
        if (embargoEntityCreate  != null) {
            embargoDetailDto = embargoMapper.fromEntityToDto(embargoEntityCreate);
        }
        return embargoDetailDto;
    }

    /**
     * Cập nhập loại hàng bị cấm vận
     * @param id
     * @param embargoCreateDto
     * @return
     */
    public EmbargoDetailDto updateEmbargo (UUID id , EmbargoCreateDto embargoCreateDto) {
        EmbargoEntity embargoEntity = embargoMapper.fromEmbargoCreateDto(embargoCreateDto);
        embargoEntity.setId(id);
        embargoRepository.save(embargoEntity);
        EmbargoDetailDto embargoDetailDto = embargoMapper.fromEntityToDto(embargoEntity);
        return embargoDetailDto;
    }

    /**
     * Loại hàng hết bị cấm vận
     * @param id
     */
    public void deleteById(UUID id) {
        embargoRepository.deleteById(id);
    }

}
