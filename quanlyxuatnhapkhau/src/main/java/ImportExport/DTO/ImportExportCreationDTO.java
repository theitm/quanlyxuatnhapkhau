package ImportExport.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportExportCreationDTO {
    public UUID id;
    public String idCountry;
    public String warehouse;
    public Date date;
    public TinyIntTypeDescriptor type;
    private List<UUID> countryId;
    private List<UUID> warehouseId;
}
