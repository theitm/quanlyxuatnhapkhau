package ImportExport.mapper;


/*import ImportExport.dto.CommodityDTO;
import ImportExport.entity.Commodity;
import ImportExport.entity.DetailsImportExport;

public class CommodityMapper {
    private static CommodityMapper INSTANCE;

    public static CommodityMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommodityMapper();
        }
        return INSTANCE;
    }
    public CommodityDTO toDTO (Commodity commodity) {
        CommodityDTO dto = new CommodityDTO();
        dto.setId(commodity.getId());
        dto.setIdTypeOfCommodity(commodity.getIdTypeOfCommodity());
        dto.setCommodityName(commodity.getCommodityName());
        dto.setPrice(commodity.getPrice());
        dto.setUnit(commodity.getUnit());
        dto.setDescription(commodity.getDescription());
        return dto;

    }
    public Commodity toEntity (CommodityDTO commodityDTO) {
        Commodity commodity = new Commodity();
        commodity.setId(commodityDTO.getId());
        commodity.setIdTypeOfCommodity(commodityDTO.getIdTypeOfCommodity());
        commodity.setCommodityName(commodityDTO.getCommodityName());
        commodity.setPrice(commodityDTO.getPrice());
        commodity.setUnit(commodityDTO.getUnit());
        commodity.setDescription(commodityDTO.getDescription());
        return commodity;
    }

}
*/

import ImportExport.dto.CommodityDTO;
import ImportExport.entity.Commodity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CommodityMapper {
    CommodityDTO toCommodityDTO(Commodity commodity);
    List<CommodityDTO> toCommodityDTOs (List<Commodity> commodities);
    Commodity toCommodity(CommodityDTO commodityDTO);


}