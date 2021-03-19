package com.haonguyen.ExportService.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelDocumentDTO {

    @Type(type = "uuid-char")
    private UUID id;
    private String imageUrl;
}