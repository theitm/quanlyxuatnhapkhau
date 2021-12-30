package ImportExport.Mapper;

import ImportExport.DTO.TypeOfCommodityDTO;
import ImportExport.entity.TypeOfCommodityEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TypeOfCommodityMapper {
    TypeOfCommodityEntity fromTypeOfCommodityDTO(TypeOfCommodityDTO typeOfCommodityDTO);
    TypeOfCommodityDTO fromTypeOfCommodityEntity(TypeOfCommodityEntity typeOfCommodityEntity);
}
