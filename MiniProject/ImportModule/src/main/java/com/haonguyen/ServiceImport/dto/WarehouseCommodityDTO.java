package com.haonguyen.ServiceImport.dto;

import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.WarehouseEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Collection;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class WarehouseCommodityDTO {
    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private WarehouseEntity idWarehouse;
    @Type(type = "uuid-char")
    Collection<DetailsImportExportEntity> commodityEntities;

    private Collection<ItemReceiptDTO> itemReceiptDTOS;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public WarehouseEntity getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(WarehouseEntity idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public Collection<DetailsImportExportEntity> getCommodityEntities() {
        return commodityEntities;
    }

    public void setCommodityEntities(Collection<DetailsImportExportEntity> commodityEntities) {
        this.commodityEntities = commodityEntities;
    }

    public Collection<ItemReceiptDTO> getItemReceiptDTOS() {
        return itemReceiptDTOS;
    }

    public void setItemReceiptDTOS(Collection<ItemReceiptDTO> itemReceiptDTOS) {
        this.itemReceiptDTOS = itemReceiptDTOS;
    }
}
