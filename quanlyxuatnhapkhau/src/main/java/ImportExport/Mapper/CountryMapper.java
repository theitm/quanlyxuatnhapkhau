package ImportExport.Mapper;

import ImportExport.DTO.CommodityDTO;
import ImportExport.entity.CommodityEntity;

public class CountryMapper {
    private static CountryMapper INSTANCE;
    public static CountryMapper getINSTANCE(){
        if (INSTANCE == null) {
            INSTANCE = new CountryMapper();
        }
        return  INSTANCE;
    }
    public CommodityEntity toEntity(CommodityDTO commodityDTO){
        CommodityEntity commodityEntity =new CommodityEntity();
        commodityEntity.setCommodityName(commodityDTO.getCommodityName());
        return commodityEntity;
    }
    public CommodityDTO toDTO(CommodityEntity commodityEntity){
        CommodityDTO dto = new CommodityDTO();
        dto.setCommodityName(commodityEntity.getCommodityName());
        return dto;
    }
}
