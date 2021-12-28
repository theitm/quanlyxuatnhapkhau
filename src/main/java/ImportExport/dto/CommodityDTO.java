package ImportExport.dto;

import ImportExport.entity.DetailsImportExport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommodityDTO implements Serializable {
    private UUID id;
    private String idTypeOfCommodity;
    private String commodityName;
    private float price;
    private String unit;
    private String description;


}
