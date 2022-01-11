package ImportExport.dto.country;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CountryCreateDto implements Serializable {
    private String countryName;
    private Double tax;
    private Double transportFee;
}
