package ImportExport.DTO;
import java.io.Serializable;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDTO implements Serializable {
    private UUID id;
    private String warehouse_name;
    private String description;
    private double capacity;
}
