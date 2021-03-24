package com.haonguyen.ServiceImport.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
public class ImportReceiptDTO {
    @NotNull
    private UUID id;
    @NotNull
    private UUID idCountry;
    @NotNull
    private UUID idWarehouse;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private int type;
    private Double total;
    private List<ItemReceiptDTO> item;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(UUID idCountry) {
        this.idCountry = idCountry;
    }

    public UUID getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(UUID idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ItemReceiptDTO> getItem() {
        return item;
    }

    public void setItem(List<ItemReceiptDTO> item) {
        this.item = item;
    }
}
