package com.haonguyen.CommodityService.dto;


import org.hibernate.annotations.Type;

import java.util.UUID;


public class TypeAndTaxCommodityAPI {
    @Type(type = "uuid-char")
    private UUID idTypeOfCommodity;
    private String typeOfCommodityName;

    @Type(type = "uuid-char")
    private UUID commodityId;
    private String commodityName;
    private Float commodityPrice;
    private String commodityUnit;

    @Type(type = "uuid-char")
    private UUID idTaxBracket;
    private String taxBracketName;
    private Float coefficient;
    public TypeAndTaxCommodityAPI(){}

    public TypeAndTaxCommodityAPI(UUID idTypeOfCommodity,
                                  String typeOfCommodityName,
                                  UUID commodityId,
                                  String commodityName,
                                  Float commodityPrice,
                                  String commodityUnit,
                                  UUID idTaxBracket,
                                  String taxBracketName,
                                  Float coefficient) {
        this.idTypeOfCommodity = idTypeOfCommodity;
        this.typeOfCommodityName = typeOfCommodityName;
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.commodityPrice = commodityPrice;
        this.commodityUnit = commodityUnit;
        this.idTaxBracket = idTaxBracket;
        this.taxBracketName = taxBracketName;
        this.coefficient = coefficient;
    }

    public UUID getIdTypeOfCommodity() {
        return idTypeOfCommodity;
    }

    public void setIdTypeOfCommodity(UUID idTypeOfCommodity) {
        this.idTypeOfCommodity = idTypeOfCommodity;
    }

    public String getTypeOfCommodityName() {
        return typeOfCommodityName;
    }

    public void setTypeOfCommodityName(String typeOfCommodityName) {
        this.typeOfCommodityName = typeOfCommodityName;
    }

    public UUID getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(UUID commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Float getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(Float commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityUnit() {
        return commodityUnit;
    }

    public void setCommodityUnit(String commodityUnit) {
        this.commodityUnit = commodityUnit;
    }

    public UUID getIdTaxBracket() {
        return idTaxBracket;
    }

    public void setIdTaxBracket(UUID idTaxBracket) {
        this.idTaxBracket = idTaxBracket;
    }

    public String getTaxBracketName() {
        return taxBracketName;
    }

    public void setTaxBracketName(String taxBracketName) {
        this.taxBracketName = taxBracketName;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }
}
