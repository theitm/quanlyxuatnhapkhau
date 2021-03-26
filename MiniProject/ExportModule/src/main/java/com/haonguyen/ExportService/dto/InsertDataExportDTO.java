package com.haonguyen.ExportService.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertDataExportDTO {

    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID warehouseId;
    @Type(type = "uuid-char")
    private UUID countryId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private List<DocumentDTO> documentDTOList;
    private List<DetailsExportDTO> detailsExportDTOList;


}
