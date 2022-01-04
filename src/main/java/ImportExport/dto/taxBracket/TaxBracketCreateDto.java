package ImportExport.dto.taxBracket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaxBracketCreateDto implements Serializable {
    private String taxBracketName;
    private String description;
    private Float coefficient;
}
