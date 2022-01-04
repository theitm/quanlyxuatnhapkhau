package ImportExport.dto.document;

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

public class DocumentDetailDto implements Serializable {
    private UUID id;
    private String idImportExport;
    private String imageUrl;
}
