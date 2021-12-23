package ImportExport.Mapper;

import ImportExport.DTO.CommodityDTO;
import ImportExport.entity.Commodity;
import com.sun.org.apache.bcel.internal.generic.NEW;

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
            commodity.setCommodityName(commodityDTO.toString());
            return commodity;
    }
   /* public CommodityDTO toDTO(Commodity commodity){
        CommodityDTO dto = new CommodityDTO();
        dto.toString();
    }*/
}
