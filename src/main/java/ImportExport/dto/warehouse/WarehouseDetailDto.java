package ImportExport.dto.warehouse;

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

public class WarehouseDetailDto implements Serializable {
    private UUID id;
    private String warehouseName;
    private String description;
    private double capacity;
}
