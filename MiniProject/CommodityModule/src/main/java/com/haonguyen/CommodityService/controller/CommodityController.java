package com.haonguyen.CommodityService.controller;


import com.haonguyen.CommodityService.dto.*;
import com.haonguyen.CommodityService.iservice.ICommodityService;
import com.haonguyen.CommodityService.iservice.IWarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/v1/api/commodity")
public class CommodityController {
    private final ICommodityService iCommodityService;
    private final IWarehouseService iWarehouseService;

    public CommodityController(ICommodityService iCommodityService, IWarehouseService iWarehouseService) {

        this.iCommodityService = iCommodityService;
        this.iWarehouseService = iWarehouseService;
    }

    @PostMapping("/add")
    public CommodityCreateDto addCommodity(@RequestBody CommodityCreateDto commodityCreateDto) {
         CommodityCreateDto commodityCreateDto1= iCommodityService.addCommodity(commodityCreateDto);
        return commodityCreateDto1;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCommodity(@PathVariable("id") UUID id){

        iCommodityService.deleteCommodity(id);
    }

    @PostMapping("/search")
    public List<CommoditySearchDto> searchCommodity(@RequestBody keySearchDto keySearchDto) {
        List<CommoditySearchDto> commoditySearchDtos = iCommodityService.searchCommodity(keySearchDto.getKey());
        return commoditySearchDtos;
    }


    @GetMapping("/get/{idTypeOfCommodity}")
    public List<TypeOfCommodityDto> getCommodityByIdTypeOfCommodity(@PathVariable("idTypeOfCommodity") UUID idTypeOfCommodity){
        List<TypeOfCommodityDto> typeOfCommodityDto = iCommodityService.findCommodityByIdTypeOfCommodity(idTypeOfCommodity);
        return typeOfCommodityDto;
    }

    @PutMapping("/update")
    public CommodityUpdateDto updateCommodity(@RequestBody CommodityUpdateDto commodityUpdateDto){
        return iCommodityService.updateCommodity(commodityUpdateDto);
    }

    @PostMapping("/check")
    public List<CommodityInWarehouseDto> checkCommodityInWarehouse() {
        return iWarehouseService.checkCommodityInWarehouse();

    }
    @GetMapping("/getId/{id}")
    public CommodityCreateDto getCommodityById(@PathVariable("id") UUID id){
         CommodityCreateDto commodityCreateDto = iCommodityService.CommodityById(id);
        return commodityCreateDto;
    }

    @RequestMapping(value = "/get-type-tax/{id}")
    public TypeAndTaxCommodityAPI getTypeTaxCommodity(@PathVariable("id") UUID idCommodity){
        return iCommodityService.getTypeTaxCommodity(idCommodity);
    }

}

