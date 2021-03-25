package com.haonguyen.CommodityService.controller;



import com.haonguyen.CommodityService.apiExceptionHandler.SaveException;
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

    /**tim kiem da  dieu kien*/
    @PostMapping("/search")
    public List<CommoditySearchDto> searchCommodity(@RequestBody keySearchDto keySearchDto) {
        List<CommoditySearchDto> commoditySearchDtos = iCommodityService.searchCommodity(keySearchDto.getKey());
        return commoditySearchDtos;
    }

    /**xoa hang*/
    @DeleteMapping("/{id}")
    public void deleteCommodity(@PathVariable("id") UUID id) throws SaveException {
        iCommodityService.deleteCommodity(id);
    }

    /**tim hang theo id loai hang*/
    @GetMapping("/getIdTypeOfCommodity/{idTypeOfCommodity}")
    public List<TypeOfCommodityDto> getCommodityByIdTypeOfCommodity(@PathVariable("idTypeOfCommodity") UUID idTypeOfCommodity){

        List<TypeOfCommodityDto> typeOfCommodityDto = iCommodityService.findCommodityByIdTypeOfCommodity(idTypeOfCommodity);
        return typeOfCommodityDto;
    }
    /**them hang*/
    @PostMapping("/")
    public CommodityCreateDto addCommodity(@RequestBody CommodityCreateDto commodityCreateDto) {
         CommodityCreateDto commodityCreateDto1= iCommodityService.addCommodity(commodityCreateDto);
        return commodityCreateDto1;
    }

    /**cap nhat*/
    @PutMapping("/{id}")
    public CommodityUpdateDto updateCommodity(@RequestBody CommodityUpdateDto commodityUpdateDto,
                                              @PathVariable("id") UUID idCommodity ) throws SaveException {

        CommodityUpdateDto commodityUpdateDto1 = iCommodityService.updateCommodity(commodityUpdateDto,idCommodity);
        return commodityUpdateDto1;
    }

    /**hang ton kho*/
    @PostMapping("/check")
    public List<CommodityInWarehouseDto> checkCommodityInWarehouse() {
        List<CommodityInWarehouseDto> commodityInWarehouseDtos = iWarehouseService.checkCommodityInWarehouse();
        return commodityInWarehouseDtos;

    }
/**   lay thong tin hang th eo id*/
    @GetMapping("/{id}")
    public CommodityCreateDto getCommodityById(@PathVariable("id") UUID id){
         CommodityCreateDto commodityCreateDto = iCommodityService.CommodityById(id);
        return commodityCreateDto;
    }
/**thong tin thue*/
    @RequestMapping(value = "/getTypeTax/{id}")
    public TypeAndTaxCommodityAPI getTypeTaxCommodity(@PathVariable("id") UUID idCommodity){
        TypeAndTaxCommodityAPI typeAndTaxCommodityAPI =iCommodityService.getTypeTaxCommodity(idCommodity);
        return typeAndTaxCommodityAPI;
    }

}

