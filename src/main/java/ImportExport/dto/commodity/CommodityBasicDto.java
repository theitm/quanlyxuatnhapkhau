package ImportExport.dto.commodity;

import ImportExport.dto.typeOfCommodity.TypeOfCommodityBasicDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CommodityBasicDto implements Serializable {
    private TypeOfCommodityBasicDto typeOfCommodity;

}
