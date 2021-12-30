package ImportExport.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO implements Serializable {
    private UUID id;
    private String country_name;
    private float tax;
    private float transport_fee;

   /* @NotNull
    private List<ImportExportDTO> importExportDTOS = new ArrayList<>();

    @NotNull
    private List<EmbargoDTO> embargoDTOS = new ArrayList<>();*/
}
