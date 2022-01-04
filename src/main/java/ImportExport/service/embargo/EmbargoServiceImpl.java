package ImportExport.service.embargo;

import ImportExport.dto.embargo.EmbargoCreateDto;
import ImportExport.dto.embargo.EmbargoDetailDto;
import ImportExport.entity.EmbargoEntity;
import ImportExport.mapper.EmbargoMapper;
import ImportExport.repository.EmbargoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service

public class EmbargoServiceImpl implements EmbargoService {
    private final EmbargoRepository embargoRepository;
    private final EmbargoMapper embargoMapper;

    public EmbargoServiceImpl(EmbargoRepository embargoRepository, EmbargoMapper embargoMapper) {
        this.embargoRepository = embargoRepository;
        this.embargoMapper = embargoMapper;
    }
    public Optional<EmbargoEntity> findById(UUID id) {
        return embargoRepository.findById(id);
    }
    public EmbargoDetailDto createEmbargo(EmbargoCreateDto embargoCreateDto) {
        EmbargoEntity embargoEntity = embargoMapper.fromEmbargoCreateDto(embargoCreateDto);
        EmbargoEntity embargoEntityCreate = embargoRepository.save(embargoEntity);
        EmbargoDetailDto embargoDetailDto = null;
        if (embargoEntityCreate  != null) {
            embargoDetailDto = embargoMapper.fromEntityToDto(embargoEntityCreate);
        }
        return embargoDetailDto;
    }
}
