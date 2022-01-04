package ImportExport.mapper;

import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.document.DocumentDetailDto;
import ImportExport.entity.DocumentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DocumentMapper {
    DocumentEntity fromDocumentCreateDto(DocumentCreateDto documentCreateDto);
    DocumentDetailDto fromEntityToDto (DocumentEntity documentEntity);
}
