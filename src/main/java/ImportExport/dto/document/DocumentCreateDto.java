package ImportExport.dto.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class DocumentCreateDto implements Serializable {
    private String idImportExport;
    private String imageUrl;
}
