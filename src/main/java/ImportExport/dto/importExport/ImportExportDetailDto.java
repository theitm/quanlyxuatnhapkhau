package ImportExport.dto.importExport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImportExportDetailDto implements Serializable {
    private UUID id;
    private String idCountry;
    private String idWarehouse;
    private Date date;
    private int type;
}
