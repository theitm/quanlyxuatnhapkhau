package ImportExport.DTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ImportExportDTO implements Serializable {
    private UUID id;
    private String idCountry;
    private String warehouse;
    private Date date;
    private Byte type;

//    @NotNull
//    private List<DocumentDTO> documentDTOS = new ArrayList<>();
//
//    @NotNull
//    private List<DetailsImportExportDTO> detailsImportExportDTOS = new ArrayList<>();
//
//    private UUID countryEntityId;
//    private UUID wareHouseEntityId;
}
