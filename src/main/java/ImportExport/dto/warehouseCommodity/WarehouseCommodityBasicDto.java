package ImportExport.dto.warehouseCommodity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class WarehouseCommodityBasicDto implements Serializable {
    private double inventoryNumber;

}
