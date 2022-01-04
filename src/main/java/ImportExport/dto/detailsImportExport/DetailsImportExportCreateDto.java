package ImportExport.dto.detailsImportExport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DetailsImportExportCreateDto implements Serializable {
    private String idImportExport;
    private String idCommodity;
    private String description;
    private Double quantity;
    private Integer total;
}
