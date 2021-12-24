package ImportExport.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaxBracketDTO implements Serializable {
    private UUID id;
    private String tax_bracket_name;
    private String description;
    private Float coefficient;

}
