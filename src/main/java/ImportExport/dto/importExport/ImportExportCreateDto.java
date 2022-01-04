package ImportExport.dto.importExport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ImportExportCreateDto implements Serializable {
    private String idCountry;
    private String idWarehouse;
    private Date date;
    private int type;
}
