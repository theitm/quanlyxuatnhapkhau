package com.haonguyen.CommodityService.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor

public class CommodityCreateDto {

    @Type(type = "uuid-char")
    private UUID id;
    private String commodity_name;
    private String description;
    private Float price;
    private String unit;
    @Type(type = "uuid-char")
    private UUID id_Sectors;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
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

    public UUID getId_Sectors() {
        return id_Sectors;
    }

    public void setId_Sectors(UUID id_Sectors) {
        this.id_Sectors = id_Sectors;
    }
}
