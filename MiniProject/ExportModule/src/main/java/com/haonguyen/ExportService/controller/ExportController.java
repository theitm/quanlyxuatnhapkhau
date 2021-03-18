package com.haonguyen.ExportService.controller;


import com.haonguyen.ExportService.service.CommodityService;
import com.haonguyen.ExportService.service.CountryService;
import com.haonguyen.ExportService.service.SectorsService;
import com.mini_project.CoreModule.entity.CommodityEntity;
import com.mini_project.CoreModule.entity.CountryEntity;
import com.mini_project.CoreModule.entity.TypeOfCommodityEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/")
public class ExportController {


    private final CommodityService commodityService;
    private final SectorsService sectorsService;
    private final CountryService countryService;

    public ExportController(CommodityService commodityService, SectorsService sectorsService, CountryService countryService) {
        this.commodityService = commodityService;
        this.sectorsService = sectorsService;
        this.countryService = countryService;
    }

    @RequestMapping(value = "/get-commodities",method = RequestMethod.GET)
    public List<CommodityEntity> getCommodities(){
        return commodityService.getCommodities();
    }
    @RequestMapping(value = "/get-sectors",method = RequestMethod.GET)
    public List<TypeOfCommodityEntity> getSectors(){
        return sectorsService.getSectors();
    }
    @RequestMapping(value = "/get-countries",method = RequestMethod.GET)
    public List<CountryEntity> getCountries(){
        return countryService.getCountries();
    }
}
