package ImportExport.controller;

import ImportExport.dto.commodity.CommodityCreateDto;
import ImportExport.dto.commodity.CommodityDetailDto;
import ImportExport.service.commodity.CommodityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
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

    }

    @GetMapping("/{id}")
    public ResponseEntity<CommodityDetailDto > findById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commodityService.findById(id));
    }

    @GetMapping
    public List<CommodityDetailDto> findAll() {
        return commodityService.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CommodityDetailDto> update(@PathVariable UUID id ,
                                                     @RequestBody CommodityCreateDto commodityCreateDto) {
        CommodityDetailDto commodityDetailDto = commodityService.updateCommodity(id, commodityCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(commodityDetailDto);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity delete(@PathVariable UUID id) {
        commodityService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

