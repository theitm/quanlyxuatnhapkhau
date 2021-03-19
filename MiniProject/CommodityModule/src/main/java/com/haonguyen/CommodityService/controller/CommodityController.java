package com.haonguyen.CommodityService.controller;


import com.haonguyen.CommodityService.dto.*;
import com.haonguyen.CommodityService.service.ICommodityService;
import com.haonguyen.CommodityService.service.IWarehouseService;
import com.mini_project.Coremodule.entity.CommodityEntity;
import com.mini_project.CoreModule.entity.CommodityEntity;


import org.springframework.web.bind.annotation.*;


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


    @GetMapping("/search/{key}")
    public List<CommoditySearchDto> searchCommodity(@PathVariable("key") String key) {

        List<CommoditySearchDto> commoditySearchDtos = iCommodityService.searchCommodity(key);

        return commoditySearchDtos;
    }

    @GetMapping("/get/{id_sector}")
    public List<StyleOfCommodityDto> getCommodityBySectorId(@PathVariable("id_sector") UUID idSector){
        List<StyleOfCommodityDto> styleOfCommodityDto = iCommodityService.findCommodityBySectorId(idSector);
        return styleOfCommodityDto;

    }

    @PutMapping("/update")
    public CommodityEntity updateCommodity(@RequestBody CommodityUpdateDto commodityUpdateDto){
        return iCommodityService.updateCommodity(commodityUpdateDto);
    }

    @GetMapping("/check")
    public List<CommodityInWarehouseDto> checkCommodityInWarehouse() {
        return iWarehouseService.checkCommodityInWarehouse();

    }
}

