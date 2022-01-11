package ImportExport.mapper;

import ImportExport.dto.commodity.CommodityCreateDto;
import ImportExport.dto.commodity.CommodityDetailDto;
import ImportExport.entity.CommodityEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface CommodityMapper {
    CommodityEntity fromCommodityCreateDto(CommodityCreateDto commodityCreateDto);
    CommodityDetailDto fromEntityToDetailDto(CommodityEntity commodityEntity);
    List<CommodityDetailDto> fromEntityToDto(List<CommodityEntity> commodityEntities);
}