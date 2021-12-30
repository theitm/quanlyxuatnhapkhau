package ImportExport.DTO.Commodity;

import ImportExport.DTO.DetailsImportExportDTO;
import ImportExport.DTO.WareHouseCommodityDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommodityDTO implements Serializable {
    private UUID id;
    private UUID idTypeOfCommodity;
    private String commodityName;
    private float price;
    private String unit;
    private String description;

    /*@NotNull
    private List<DetailsImportExportDTO> detailsImportExportDTOS = new ArrayList<>();

    @NotNull
    private List<WareHouseCommodityDTO> wareHouseCommodityDTOS = new ArrayList<>();

    private UUID typeOfCommodityEntityId;*/

}
