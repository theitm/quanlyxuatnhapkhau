package ImportExport.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHoseCommodityDTO implements Serializable {
    private UUID id;
    private String id_warehouse;
    private String id_commodity;
    private double inventory_number;

    private List<UUID> wareHouseEntities;
    private List<UUID> commodities;

}