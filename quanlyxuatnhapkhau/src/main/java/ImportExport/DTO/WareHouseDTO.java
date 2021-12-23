package ImportExport.DTO;
import java.io.Serializable;
import java.util.UUID;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDTO implements Serializable {
    private UUID id;
    private String  a;
}
