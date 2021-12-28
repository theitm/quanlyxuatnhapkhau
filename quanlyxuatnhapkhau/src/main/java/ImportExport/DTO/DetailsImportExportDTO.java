package ImportExport.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailsImportExportDTO {
    public String idImportExport;
    public String idCommodity;
    public String description;
    public Double quantity;
    public Integer total;
    private List<UUID> importExports;
    private List<UUID> commodities;
}
