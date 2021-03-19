package com.haonguyen.ExportService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExportFindByIdDTO {
    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID idCountry;
    @Type(type = "uuid-char")
    private UUID idWarehouse;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;


}
