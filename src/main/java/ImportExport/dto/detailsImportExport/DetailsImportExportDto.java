package ImportExport.dto.detailsImportExport;

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
public class DetailsImportExportDto implements Serializable {
    private UUID idImportExport;
    private UUID idCommodity;
    private String description;
    private Double quantity;
    private Double total;

}
