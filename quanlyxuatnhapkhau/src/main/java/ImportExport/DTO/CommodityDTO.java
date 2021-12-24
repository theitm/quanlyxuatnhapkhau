package ImportExport.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommodityDTO {
    public UUID id;
    public String idTypeOfCommodity;
    public String commodityName;
    public float price;
    public String unit;
    public String description;
    private List<UUID> typeOfCommodities;
}
