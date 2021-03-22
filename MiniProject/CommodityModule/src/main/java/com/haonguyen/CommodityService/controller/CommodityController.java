package com.haonguyen.CommodityService.controller;


import com.haonguyen.CommodityService.dto.*;
import com.haonguyen.CommodityService.service.ICommodityService;
import com.haonguyen.CommodityService.service.IWarehouseService;
import com.mini_project.CoreModule.entity.CommodityEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/commodity")
public class CommodityController {
    private final ICommodityService iCommodityService;
    private final IWarehouseService iWarehouseService;

    public CommodityController(ICommodityService iCommodityService, IWarehouseService iWarehouseService) {

        this.iCommodityService = iCommodityService;
        this.iWarehouseService = iWarehouseService;
    }


    @PostMapping("/add")
    public CommodityEntity addCommodity(@RequestBody CommodityCreateDto commodityCreateDto) {
        return iCommodityService.addCommodity(commodityCreateDto);
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

