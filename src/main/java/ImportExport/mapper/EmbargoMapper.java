package ImportExport.mapper;

import ImportExport.dto.embargo.EmbargoCreateDto;
import ImportExport.dto.embargo.EmbargoDetailDto;
import ImportExport.entity.EmbargoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmbargoMapper {
    EmbargoEntity fromEmbargoCreateDto(EmbargoCreateDto embargoCreateDto);
    EmbargoDetailDto fromEntityToDto (EmbargoEntity embargoEntity);
    List<EmbargoDetailDto> fromListEntityToDto (List<EmbargoEntity> embargoEntities);
}
