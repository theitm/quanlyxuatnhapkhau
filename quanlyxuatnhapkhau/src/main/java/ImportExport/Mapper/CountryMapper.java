package ImportExport.Mapper;

import ImportExport.DTO.CommodityDTO;
import ImportExport.entity.Commodity;

public class CountryMapper {
    private static CountryMapper INSTANCE;
    public static CountryMapper getINSTANCE(){
        if (INSTANCE == null) {
            INSTANCE = new CountryMapper();
        }
        return  INSTANCE;
    }
    public Commodity toEntity(CommodityDTO commodityDTO){
        Commodity commodity =new Commodity();
        commodity.setCommodityName(commodityDTO.getCommodityName());
        return commodity;
    }
    public CommodityDTO toDTO(Commodity commodity){
        CommodityDTO dto = new CommodityDTO();
        dto.setCommodityName(commodity.getCommodityName());
        dto.setId(commodity.getId());
        return dto;
    }
}
