package com.haonguyen.ServiceImport.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
public class ItemReceiptDTO {
    private UUID idCommodity;
    private String description;
    private Double quantity;
    private Double total;
    private List<String> imageUrl;

    public UUID getIdCommodity() {
        return idCommodity;
    }

    public void setIdCommodity(UUID idCommodity) {
        this.idCommodity = idCommodity;
    }

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


}
