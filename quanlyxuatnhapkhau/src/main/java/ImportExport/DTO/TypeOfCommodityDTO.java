package ImportExport.DTO;

import ImportExport.DTO.Commodity.CommodityDTO;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfCommodityDTO {
    private UUID id;
    private String idTaxBracket;
    private String typeOfCommodityName;
    private String description;

//    @NotNull
//    private List<EmbargoDTO> embargoDTOS = new ArrayList<>();
//
//    @NotNull
//    private List<CommodityDTO> commodityDTOS = new ArrayList<>();
//
//    private UUID taxBracketEntityId;
}
