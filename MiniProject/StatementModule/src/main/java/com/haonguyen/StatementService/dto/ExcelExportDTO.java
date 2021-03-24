package com.haonguyen.StatementService.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExcelExportDTO {
    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID idWarehouse;
    @Type(type = "uuid-char")
    private UUID idCountry;
    private String countryName;
    private String warehouseName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;


}
