package com.haonguyen.ServiceImport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WarehouseDTO {

    private String idWarehouse;
    private String warehouseName;
    private String description;
    private Double capacity;


}
