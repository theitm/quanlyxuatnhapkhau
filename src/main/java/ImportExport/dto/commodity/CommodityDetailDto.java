package ImportExport.dto.commodity;

import ImportExport.dto.detailsImportExport.DetailsImportExportBasicDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityBasicDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityBasicDto;
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
public class CommodityDetailDto implements Serializable {
    private UUID id;
    private UUID idTypeOfCommodity;
    private String commodityName;
    private float price;
    private String unit;
    private String description;
    private TypeOfCommodityBasicDto typeOfCommodity;
    private List<WarehouseCommodityBasicDto> warehouseCommodities;
    private List<DetailsImportExportBasicDto> detailsImportExports;

}
