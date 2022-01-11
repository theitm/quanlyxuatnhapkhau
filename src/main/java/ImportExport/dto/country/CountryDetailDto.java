package ImportExport.dto.country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CountryDetailDto implements Serializable {
    private UUID id;
    private String countryName;
    private Double tax;
    private Double transportFee;

}
