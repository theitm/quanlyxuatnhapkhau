package ImportExport.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TypeOfCommodityDTO {
    public UUID id;
    public String idTaxBracket;
    public String typeOfCommodityName;
    public String description;
    private List<UUID> taxBracketEntities;
}
