package com.haonguyen.CommodityService.dto;


import org.hibernate.annotations.Type;

import java.util.UUID;


public class CommoditySearchDto {

    private String commodityName;
    private String description;
    private Float price;
    private String unit;
    @Type(type = "uuid-char")
    private UUID idTypeOfCommodity;

    public CommoditySearchDto(String commodityName, String description, Float price, String unit, UUID idTypeOfCommodity) {
        this.commodityName = commodityName;
        this.description = description;
        this.price = price;
        this.unit = unit;
        this.idTypeOfCommodity = idTypeOfCommodity;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public UUID getIdTypeOfCommodity() {
        return idTypeOfCommodity;
    }

    public void setIdTypeOfCommodity(UUID idTypeOfCommodity) {
        this.idTypeOfCommodity = idTypeOfCommodity;
    }
}
