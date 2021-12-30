package ImportExport.DTO;



import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
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
public class TaxBracketDTO implements Serializable {
    private UUID id;
    private String tax_bracket_name;
    private String description;
    private Float coefficient;

//    @NotNull
//    private List <TypeOfCommodityDTO> typeOfCommodityDTOS = new ArrayList<>();

}
