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

public class DocumentCreateDto implements Serializable {
    private UUID idImportExport;
    private String imageUrl;
}