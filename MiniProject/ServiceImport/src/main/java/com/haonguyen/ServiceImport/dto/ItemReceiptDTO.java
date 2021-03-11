package com.haonguyen.ServiceImport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemReceiptDTO {
    private String idCommodity;
    private String description;
    private Double quantity;
    private Double total;
    private List<String> imageUrl;
}
