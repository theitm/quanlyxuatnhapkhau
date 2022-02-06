package ImportExport.dto.warehouseCommodity;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class WarehouseCommodityDetailDto implements Serializable {
    private UUID id;
    private UUID idWarehouse;
    private UUID idCommodity;
    private double inventoryNumber;

}
