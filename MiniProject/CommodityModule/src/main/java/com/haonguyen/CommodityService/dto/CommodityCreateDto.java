package com.haonguyen.CommodityService.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor

public class CommodityCreateDto {


    private String commodityName;
    private String description;
    private Float price;
    private String unit;
    @Type(type = "uuid-char")
    private UUID idTypeOfCommodity;

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
