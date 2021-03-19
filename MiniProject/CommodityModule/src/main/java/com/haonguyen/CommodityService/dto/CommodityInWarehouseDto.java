package com.haonguyen.CommodityService.dto;

public class CommodityInWarehouseDto {

    private String commodity_name;
    private String warehouse_name;
    private Double inventoryNumber;

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public Double getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(Double inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }
}
