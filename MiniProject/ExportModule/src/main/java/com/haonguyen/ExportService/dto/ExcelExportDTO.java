package com.haonguyen.ExportService.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.mapstruct.Mapper;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExcelExportDTO {

    @Type(type = "uuid-char")
    private UUID id;

    private String countryName;

    private String warehouseName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
