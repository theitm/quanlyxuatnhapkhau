package com.haonguyen.ExportService.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuantityUsingInImport {

    @Type(type = "uuid-char")
    private UUID idRefExport;
    @Type(type = "uuid-char")
    private UUID idCommodity;
    @Type(type = "uuid-char")
    private UUID idImport;
    @Type(type = "uuid-char")
    private Double quantityTaken;
}
