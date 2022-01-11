package ImportExport.service.embargo;


import ImportExport.dto.embargo.EmbargoCreateDto;
import ImportExport.dto.embargo.EmbargoDetailDto;
import ImportExport.entity.EmbargoEntity;

import java.util.List;
import java.util.UUID;

public interface EmbargoService {
    EmbargoDetailDto createEmbargo(EmbargoCreateDto embargoCreateDto);
    EmbargoDetailDto findById(UUID id);
    List<EmbargoDetailDto> findAll();
    void deleteById(UUID id);
    EmbargoDetailDto updateEmbargo (UUID id , EmbargoCreateDto embargoCreateDto);
}
