package ImportExport.DTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotNull;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDTO implements Serializable {
    private UUID id;
    private String warehouse_name;
    private String description;
    private double capacity;

//    @NotNull
//    private List<ImportExportDTO> importExportDTOS = new ArrayList<>();
//
//    @NotNull
//    private List<WareHouseCommodityDTO> wareHouseCommodityDTOS = new ArrayList<>();
}
