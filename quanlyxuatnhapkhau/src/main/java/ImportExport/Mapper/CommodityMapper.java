package ImportExport.Mapper;

import ImportExport.DTO.Commodity.CommodityCreateDto;
import ImportExport.DTO.Commodity.CommodityDTO;

import ImportExport.entity.CommodityEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CommodityMapper {
    CommodityEntity fromCommodityCreateDto(CommodityCreateDto commodityCreateDto);
    CommodityDTO fromEntityToDetailDto(CommodityEntity commodityEntity);
}
