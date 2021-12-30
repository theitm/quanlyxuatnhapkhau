package ImportExport.DTO;


import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DocumentDTO implements Serializable {
    private UUID id;
    private String idImportExport;
    private String imageUrl;

//    private UUID importExportEntityId;
}
