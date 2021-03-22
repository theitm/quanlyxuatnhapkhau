package com.haonguyen.ExportService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailsExportDTO {


    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID idCommodity;
    @Type(type = "uuid-char")
    private UUID idImportExport;
    private Double quantity;
    private String description;
    private Double total;
}
