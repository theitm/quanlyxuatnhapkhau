package com.haonguyen.CommodityService.controller;


import com.haonguyen.CommodityService.dto.CommodityCreateDto;
import com.haonguyen.CommodityService.service.ICommodityService;
import com.mini_project.Coremodule.entity.CommodityEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/commodity")
public class CommodityController {
    private final ICommodityService iCommodityService;

    public CommodityController(ICommodityService iCommodityService) {

        this.iCommodityService = iCommodityService;
    }

//    @PutMapping("/update")
//    public CommodityEntity updateCommodity(@RequestBody CommodityEntity commodityEntity){
//
//        return iCommodityService.updateCommodity(commodityEntity);
//    }
//    @PostMapping("/add")
//    public CommodityEntity addCommodity(@RequestBody CommodityEntity commodityEntity){
//        return iCommodityService.addCommodity(commodityEntity);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteCommodity(@PathVariable("id") UUID id){
//        iCommodityService.deleteCommodity(id);
//    }
//
//    @GetMapping("/search/{id}")
//    public CommodityEntity searchCommodity(@PathVariable("id") UUID id){
//        return  new CommodityEntity(this.iCommodityService.findCommodityById(id),HttpStatus.OK);
//    }
//
//    @GetMapping("/get/{id}")
//    public List<CommodityEntity> getCommodityById_Sectors(@PathVariable("idSector") UUID id_Sectors){
//        return iCommodityService.findCommodityById_Sectors(id_Sectors);
//    }
    @PostMapping("/save")
    public CommodityEntity addCommodity(@RequestBody CommodityCreateDto commodityCreateDto) {
        return iCommodityService.addCommodity(commodityCreateDto);
    }
//    @GetMapping("/check")
//    public List<CommodityWarehouseDTO> checkCommodityInWarehouse() {
//        return warehouseService.checkCommodityInWarehouse();
//
//    }
}

