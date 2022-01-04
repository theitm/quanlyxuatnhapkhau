package ImportExport.dto.commodity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CommodityCreateDto implements Serializable {
    private String idTypeOfCommodity;
    private String commodityName;
    private float price;
    private String unit;
    private String description;
}
