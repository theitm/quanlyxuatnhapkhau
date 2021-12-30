package ImportExport.DTO;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseCommodityDTO implements Serializable {
    private UUID id;
    private String id_warehouse;
    private String id_commodity;
    private double inventory_number;
//
//    private UUID wareHouseEntityId;
//    private UUID commodityEntityId;
}
