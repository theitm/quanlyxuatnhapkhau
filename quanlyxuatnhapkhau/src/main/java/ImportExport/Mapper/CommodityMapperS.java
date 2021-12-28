package ImportExport.Mapper;

import ImportExport.DTO.CommodityDTO;
import ImportExport.entity.CommodityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface CommodityMapperS {
    CommodityDTO map(CommodityEntity commodityEntity);
    CommodityEntity map(CommodityDTO commodityDTO);
    List<CommodityDTO> map(List<CommodityDTO> commodityDTOS);
}
