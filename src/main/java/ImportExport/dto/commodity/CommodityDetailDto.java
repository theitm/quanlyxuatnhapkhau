package ImportExport.dto.commodity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommodityDetailDto implements Serializable {
    private UUID id;
    private String idTypeOfCommodity;
    private String commodityName;
    private float price;
    private String unit;
    private String description;


}
