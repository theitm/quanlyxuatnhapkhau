package ImportExport.dto.taxBracket;

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

public class TaxBracketDetailDto implements Serializable {
    private UUID id;
    private String taxBracketName;
    private String description;
    private Float coefficient;
}
