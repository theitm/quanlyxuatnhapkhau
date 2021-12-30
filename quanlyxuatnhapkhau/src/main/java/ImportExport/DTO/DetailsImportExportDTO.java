package ImportExport.DTO;

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
public class DetailsImportExportDTO implements Serializable {
    private UUID id;
    private String idImportExport;
    private String idCommodity;
    private String description;
    private Double quantity;
    private Integer total;

//    private UUID importExportEntityId;
//    private UUID commodityEntityId;
}
