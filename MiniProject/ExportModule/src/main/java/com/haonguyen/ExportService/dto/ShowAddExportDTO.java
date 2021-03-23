package com.haonguyen.ExportService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowAddExportDTO {

    @Type(type = "uuid-char")
    private UUID idImportExport;
    @Type(type = "uuid-char")
    private UUID idWarehouse;
    @Type(type = "uuid-char")
    private UUID idCountry;
    private String warehouseName;
    private String countryName;
    private List<DocumentDTO> documentDTOList;
    private List<DetailsExportDTO> detailsExportDTOList;
    private Double transportationCosts;
    private Double subTotal;


}
