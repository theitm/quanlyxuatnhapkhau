package ImportExport.dto.detailsImportExport;

import ImportExport.dto.commodity.CommodityBasicDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DetailsImportExportBasicDto {
    private Double quantity;
    private Double total;
    private CommodityBasicDto commodity;
}
