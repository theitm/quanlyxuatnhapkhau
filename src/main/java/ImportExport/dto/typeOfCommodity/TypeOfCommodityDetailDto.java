package ImportExport.dto.typeOfCommodity;

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

public class TypeOfCommodityDetailDto implements Serializable {
    private UUID id;
    private String idTaxBracket;
    private String typeOfCommodityName;
    private String description;
}
