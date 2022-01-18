package ImportExport.dto.importExport;

import ImportExport.dto.detailsImportExport.DetailsImportExportBasicDto;
import ImportExport.dto.document.DocumentCreateDto;
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

public class ImportExportDto implements Serializable {
    private UUID idCountry;
    private UUID idWarehouse;
    private Date date;
    private int type;
    private List<DetailsImportExportBasicDto> detailsImportExports;
    private List<DocumentCreateDto> documents;
}
