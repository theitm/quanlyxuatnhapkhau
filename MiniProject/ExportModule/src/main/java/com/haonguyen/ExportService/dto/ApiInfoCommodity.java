package com.haonguyen.ExportService.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiInfoCommodity {

    @Type(type = "uuid-char")
    private UUID idTypeOfCommodity;
    private String typeOfCommodityName;

    @Type(type = "uuid-char")
    private UUID commodityId;
    private String commodityName;
    private Float commodityPrice;
    private String commodityUnit;

    @Type(type = "uuid-char")
    private UUID idTaxBracket;
    private String taxBracketName;
    private Float coefficient;

}
