package ImportExport.dto.typeOfCommodity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class TypeOfCommodityCreateDto implements Serializable {
    private String idTaxBracket;
    private String typeOfCommodityName;
    private String description;
}
