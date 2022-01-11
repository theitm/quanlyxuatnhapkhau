package ImportExport.mapper;

import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.document.DocumentDetailDto;
import ImportExport.entity.DocumentEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper

public interface DocumentMapper {
    DocumentEntity fromDocumentCreateDto(DocumentCreateDto documentCreateDto);
    DocumentDetailDto fromEntityToDto (DocumentEntity documentEntity);
    List<DocumentDetailDto> fromListEntityToDto (List<DocumentEntity> documentEntities);
}
