package com.internship.ExportService.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Date;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ExportDTO {

    @Type(type = "uuid-char")
    private UUID id;
    @Type(type = "uuid-char")
    private UUID id_warehouse;
    @Type(type = "uuid-char")
    private UUID id_country;
    @JsonProperty("date")
    private Date date;
    private int type;



    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getId_warehouse() {
        return id_warehouse;
    }
    public void setId_warehouse(UUID id_warehouse) {
        this.id_warehouse = id_warehouse;
    }
    public UUID getId_country() {
        return id_country;
    }
    public void setId_country(UUID id_country) {
        this.id_country = id_country;
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
}
