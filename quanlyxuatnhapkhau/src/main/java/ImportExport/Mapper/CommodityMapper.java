package ImportExport.Mapper;

import ImportExport.DTO.CommodityDTO;
import ImportExport.entity.CommodityEntity;

public class CommodityMapper {
    private static CommodityMapper INSTANCE;
    public static CommodityMapper getINSTANCE(){
        if (INSTANCE == null) {
            INSTANCE = new CommodityMapper();
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
        dto.setPrice(commodityEntity.getPrice());
        dto.setUnit(commodityEntity.getUnit());
        dto.setDescription(commodityEntity.getDescription());
        return dto;
    }
   /* public CommodityDTO toDTO(Commodity commodity) {
        CommodityDTO commodityDTO = new CommodityDTO();
        commodityDTO.setCommodityName(commodity.getCommodityName());
        commodityDTO.setTypeOfCommodities(commodity.getTypeOfCommodities().stream()
                .map(typeOfCommodity -> TypeOfCommodityMapper. ().toDTO(typeOfCommodity))
                .collect(Collectors.toList()));
        return dto;
    }*/


}
