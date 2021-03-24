package com.haonguyen.StatementService.dto;

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
public class ExcelDetailsExportDTO {

    @Type(type = "uuid-char")
    private UUID idCommodity;
    private String commodityName;
    private String typeOfCommodityName;
    private Double quantity;
    private Float price;
    private Double total;

}
