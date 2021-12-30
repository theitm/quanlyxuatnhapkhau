package ImportExport.Mapper;

import ImportExport.DTO.WareHouseDTO;
import ImportExport.entity.WareHouseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface WareHouseMapper {
    WareHouseEntity fromWareHouseDTO(WareHouseDTO wareHouseDTO);
    WareHouseDTO fromWareHouseEntity(WareHouseEntity wareHouseEntity);
}
