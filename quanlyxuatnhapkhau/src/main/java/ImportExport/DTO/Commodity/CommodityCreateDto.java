package ImportExport.DTO.Commodity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommodityCreateDto {
    private UUID idTypeOfCommodity;
    private String commodityName;
    private float price;
    private String unit;
    private String description;
}
