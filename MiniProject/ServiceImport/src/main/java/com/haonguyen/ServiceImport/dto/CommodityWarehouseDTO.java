package com.haonguyen.ServiceImport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommodityWarehouseDTO {

    private Long id;
    private String idWarehouse;
    private String idCommodity;
    private Double inventoryNumber;

}

