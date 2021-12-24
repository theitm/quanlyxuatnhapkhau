package ImportExport.Mapper;

import ImportExport.DTO.CommodityDTO;
import ImportExport.DTO.CountryDTO;
import ImportExport.entity.Commodity;
import ImportExport.entity.CountryEntity;
import ImportExport.entity.TypeOfCommodity;

public class CommodityMapper {
    private static CommodityMapper INSTANCE;
    public static CommodityMapper getINSTANCE(){
        if (INSTANCE == null) {
            INSTANCE = new CommodityMapper();
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
        dto.setIdTypeOfCommodity(commodity.getIdTypeOfCommodity());
        dto.setCommodityName(commodity.getCommodityName());
        dto.setPrice(commodity.getPrice());
        dto.setUnit(commodity.getUnit());
        dto.setDescription(commodity.getDescription());
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
