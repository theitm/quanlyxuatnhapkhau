package ImportExport.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImportExportDTO implements Serializable {
    public UUID id;
    public String idCountry;
    public String warehouse;
    public Date date;
    public TinyIntTypeDescriptor type;
    private List<CountryDTO> country;
}
