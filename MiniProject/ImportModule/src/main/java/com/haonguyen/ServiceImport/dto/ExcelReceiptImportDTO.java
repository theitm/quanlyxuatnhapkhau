package com.haonguyen.ServiceImport.dto;

import com.mini_project.CoreModule.entity.DetailsImportExportEntity;
import com.mini_project.CoreModule.entity.DocumentEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
public class ExcelReceiptImportDTO {
    @Type(type = "uuid-char")
    private UUID id;
    private String countryName;
    private String warehouseName;
    private Date date;
    Collection<DetailsImportExportEntity> detailsImportExportEntities;
    Collection<DocumentEntity> documentEntities;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Collection<DetailsImportExportEntity> getDetailsImportExportEntities() {
        return detailsImportExportEntities;
    }

    public void setDetailsImportExportEntities(Collection<DetailsImportExportEntity> detailsImportExportEntities) {
        this.detailsImportExportEntities = detailsImportExportEntities;
    }

    public Collection<DocumentEntity> getDocumentEntities() {
        return documentEntities;
    }

    public void setDocumentEntities(Collection<DocumentEntity> documentEntities) {
        this.documentEntities = documentEntities;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}
