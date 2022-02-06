package ImportExport.dto.importExport;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.warehouse.WarehouseCreateDto;
import ImportExport.entity.DocumentEntity;
import ImportExport.entity.WarehouseEntity;
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

public class ImportExportAddDto implements Serializable {
    private UUID idCountry;
    private UUID idWarehouse;
    private Date date;
    private int type;
    private List<DetailsImportExportCreateDto> detailsImportExports;
    private List<DocumentCreateDto> documents;
    private WarehouseCreateDto warehouse;
}
