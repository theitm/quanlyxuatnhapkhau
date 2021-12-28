package ImportExport.Mapper;

import ImportExport.DTO.CommodityDTO;
import ImportExport.entity.CommodityEntity;

public class TypeOfCommodityMapper {
    private static TypeOfCommodityMapper INSTANCE;
    public static TypeOfCommodityMapper getINSTANCE(){
        if (INSTANCE == null) {
            INSTANCE = new TypeOfCommodityMapper();
        }
        return  INSTANCE;
    }
    public CommodityEntity toEntity(CommodityDTO commodityDTO){
        CommodityEntity commodityEntity =new CommodityEntity();
        commodityEntity.setCommodityName(commodityDTO.getCommodityName());
        commodityEntity.setPrice(commodityDTO.getPrice());
        commodityEntity.setUnit(commodityDTO.getUnit());
        commodityEntity.setDescription(commodityDTO.getDescription());
        return commodityEntity;
    }
    public CommodityDTO toDTO(CommodityEntity commodityEntity){
        CommodityDTO dto = new CommodityDTO();
        dto.setCommodityName(commodityEntity.getCommodityName());
        return dto;
    }
}
