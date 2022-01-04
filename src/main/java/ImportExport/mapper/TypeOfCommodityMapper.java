package ImportExport.mapper;

import ImportExport.dto.typeOfCommodity.TypeOfCommodityCreateDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityDetailDto;
import ImportExport.entity.TypeOfCommodityEntity;
import org.mapstruct.Mapper;

@Mapper
public interface TypeOfCommodityMapper {
    TypeOfCommodityEntity fromTypeOfCommodityCreateDto(TypeOfCommodityCreateDto typeOfCommodityCreateDto);
    TypeOfCommodityDetailDto fromEntityToDto (TypeOfCommodityEntity typeOfCommodityEntity);
}
