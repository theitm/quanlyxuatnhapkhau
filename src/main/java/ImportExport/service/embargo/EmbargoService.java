package ImportExport.service.embargo;


import ImportExport.dto.embargo.EmbargoCreateDto;
import ImportExport.dto.embargo.EmbargoDetailDto;
import ImportExport.entity.EmbargoEntity;
import java.util.Optional;
import java.util.UUID;

public interface EmbargoService {
    EmbargoDetailDto createEmbargo(EmbargoCreateDto embargoCreateDto);
    Optional<EmbargoEntity> findById(UUID id);
}
