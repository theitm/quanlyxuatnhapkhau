package com.haonguyen.CommodityService.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class CommodityInWarehouseDto {

    private String commodityName;
    private String warehouseName;
    private Double inventoryNumber;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Double getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Double inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public CommodityInWarehouseDto(String commodityName, String warehouseName, Double inventoryNumber) {
        this.commodityName = commodityName;
        this.warehouseName = warehouseName;
        this.inventoryNumber = inventoryNumber;
    }

    public CommodityInWarehouseDto() {
    }
}
