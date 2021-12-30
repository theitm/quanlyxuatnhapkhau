package ImportExport.Mapper;

import ImportExport.DTO.DocumentDTO;
import ImportExport.entity.DocumentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DocumentMapper {
    DocumentEntity fromDocumentDTO (DocumentDTO documentDTO);
    DocumentDTO fromDocumentEntity(DocumentEntity documentEntity);
}
