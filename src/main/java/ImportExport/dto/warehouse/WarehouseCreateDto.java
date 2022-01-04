package ImportExport.dto.warehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class WarehouseCreateDto implements Serializable {
    private String warehouseName;
    private String description;
    private double capacity;
}
