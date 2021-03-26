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
public class SourceExportDTO {
    @Type(type = "uuid-char")
    private UUID idImport;
    @Type(type = "uuid-char")
    private UUID idCommodity;
    private Double quantityImport;
    private String countryImport;
    private String warehouseImport;
}
