package com.haonguyen.ExportService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDTO {

    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID idImportExport;
    private String imageUrl;
}
