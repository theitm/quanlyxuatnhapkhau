package com.haonguyen.ExportService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExportDTO {

    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID idWarehouse;
    @Type(type = "uuid-char")
    private UUID idCountry;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Integer type;
}
