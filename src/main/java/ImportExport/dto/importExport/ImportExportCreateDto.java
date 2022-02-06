package ImportExport.dto.importExport;

import ImportExport.dto.detailsImportExport.DetailsImportExportBasicDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class ImportExportCreateDto implements Serializable {
    private UUID idCountry;
    private UUID idWarehouse;
    private Date date;
    private int type;
    private List<DetailsImportExportBasicDto> detailsImportExports;

}