package ImportExport.dto.embargo;

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

public class EmbargoDetailDto implements Serializable {
    private UUID idTypeOfCommodity;
    private UUID idCountry;
    private String description;
    private int activate;
    private Integer active;
}
