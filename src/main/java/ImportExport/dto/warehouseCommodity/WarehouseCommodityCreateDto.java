package ImportExport.dto.warehouseCommodity;

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

public class WarehouseCommodityCreateDto implements Serializable {
    private UUID idWarehouse;
    private UUID idCommodity;
    private double inventoryNumber;
}
