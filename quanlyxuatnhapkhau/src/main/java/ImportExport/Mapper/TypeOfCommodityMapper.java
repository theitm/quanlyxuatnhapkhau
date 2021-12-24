package ImportExport.Mapper;

import ImportExport.DTO.CommodityDTO;
import ImportExport.entity.Commodity;

public class TypeOfCommodityMapper {
    private static TypeOfCommodityMapper INSTANCE;
    public static TypeOfCommodityMapper getINSTANCE(){
        if (INSTANCE == null) {
            INSTANCE = new TypeOfCommodityMapper();
        }
        return  INSTANCE;
    }
    public Commodity toEntity(CommodityDTO commodityDTO){
        Commodity commodity =new Commodity();
        commodity.setIdTypeOfCommodity(commodityDTO.getIdTypeOfCommodity());
        commodity.setCommodityName(commodityDTO.getCommodityName());
        commodity.setPrice(commodityDTO.getPrice());
        commodity.setUnit(commodityDTO.getUnit());
        commodity.setDescription(commodityDTO.getDescription());
        return commodity;
    }
    public CommodityDTO toDTO(Commodity commodity){
        CommodityDTO dto = new CommodityDTO();
        dto.setCommodityName(commodity.getCommodityName());
        dto.setId(commodity.getId());
        return dto;
    }
}
