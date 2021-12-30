package ImportExport.Mapper;

import ImportExport.DTO.WareHouseCommodityDTO;
import ImportExport.entity.WareHouseCommodityEntity;
import org.mapstruct.Mapper;

@Mapper
public interface WareHouseCommodityMapper {
    WareHouseCommodityEntity fromWareHouseCommodityDTO(WareHouseCommodityDTO wareHouseCommodityDTO);
    WareHouseCommodityDTO fromWareHouseCommodityEntity(WareHouseCommodityEntity wareHouseCommodityEntity);
}
