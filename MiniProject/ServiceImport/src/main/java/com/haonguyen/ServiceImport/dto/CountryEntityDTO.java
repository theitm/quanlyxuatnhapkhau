package com.haonguyen.ServiceImport.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryEntityDTO {

    private UUID idCountry;
    private String countryName;
    private Double tax;
    private Double transportFee;

}
