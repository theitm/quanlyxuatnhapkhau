package com.haonguyen.ExportService.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultAPICommodityInfo{

    private String commodityName;
    private Double price;
    private String unit;

}
