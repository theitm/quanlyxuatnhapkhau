package ImportExport.Mapper;

import ImportExport.DTO.EmbargoDTO;
import ImportExport.entity.EmbargoEntity;
import org.mapstruct.Mapper;

@Mapper
public interface EmbargoMapper {
    EmbargoEntity fromEmbargoDTO(EmbargoDTO embargoDTO);
    EmbargoDTO fromEmbargoEntity(EmbargoEntity embargoEntity);

}
