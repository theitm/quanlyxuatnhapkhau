package ImportExport.DTO;

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
public class EmbargoDTO implements Serializable {
    private UUID id;
    private String id_type_of_commodity;
    private String id_country;
    private String description;
    private int activate;
    private Integer active;
//
//    private UUID countryEntityId;
//    private UUID typeOfCommodityEntityId;
}
