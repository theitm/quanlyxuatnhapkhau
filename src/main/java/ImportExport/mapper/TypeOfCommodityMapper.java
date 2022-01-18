package ImportExport.mapper;

import ImportExport.dto.typeOfCommodity.TypeOfCommodityBasicDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityCreateDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityDetailDto;
import ImportExport.entity.TypeOfCommodityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TypeOfCommodityMapper {
    TypeOfCommodityEntity fromTypeOfCommodityCreateDto(TypeOfCommodityCreateDto typeOfCommodityCreateDto);
    TypeOfCommodityDetailDto fromEntityToDto (TypeOfCommodityEntity typeOfCommodityEntity);
    List<TypeOfCommodityDetailDto> fromListEntityToDto (List<TypeOfCommodityEntity> typeOfCommodityEntities);

    TypeOfCommodityBasicDto fromEntityBasicToDto (TypeOfCommodityEntity typeOfCommodityEntity);
    List<TypeOfCommodityBasicDto> fromEntityListBasicDto (List<TypeOfCommodityEntity> typeOfCommodityEntities);

}
