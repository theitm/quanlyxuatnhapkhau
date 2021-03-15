package com.haonguyen.ServiceImport.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImportReceiptDTO {
    private UUID idIexport;
    private String nameCountry;
    private String nameWarehouse;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateReceipt;
    private int type;
    private Double total;
    private List<ItemReceiptDTO> item;
}
