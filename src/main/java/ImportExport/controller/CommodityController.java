package ImportExport.controller;

import ImportExport.dto.commodity.CommodityCreateDto;
import ImportExport.dto.commodity.CommodityDetailDto;
import ImportExport.service.commodity.CommodityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/commodity")

public class CommodityController {
    private final CommodityService commodityService ;

    public CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }


    @PostMapping
    public ResponseEntity<CommodityDetailDto> create(@RequestBody CommodityCreateDto createDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commodityService.createCommodity(createDto));
    //        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommodityDetailDto> findById(@PathVariable UUID id) {
     //   Optional<Commodity> commodity = commodityService.findById(id);
     //   return ResponseEntity.ok(commodityMapper.toCommodityDTO(commodity.get()));
        return null;
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<CommodityDTO> update(@PathVariable UUID id ,@RequestBody CommodityDTO commodityDTO) {
//        Commodity commodity = commodityMapper.toCommodity(commodityDTO);
//        commodity.setId(id);
//        commodityService.save(commodity);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commodityDTO);
//    }
//    @DeleteMapping("/{id}")
//    public  ResponseEntity delete(@PathVariable UUID id) {
//        commodityService.deleteById(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//    }


}

