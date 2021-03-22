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
    private UUID idCommodity;
    private Double quantity;
    private Double total;
}
