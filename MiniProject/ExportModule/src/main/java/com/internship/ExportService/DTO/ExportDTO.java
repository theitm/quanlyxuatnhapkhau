package com.internship.ExportService.DTO;

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
    private UUID id_warehouse;
    @Type(type = "uuid-char")
    private UUID id_country;
    private Date date;
    private int type;
}
