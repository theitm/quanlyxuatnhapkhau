package ImportExport.controller;

import ImportExport.dto.warehouseCommodity.WarehouseCommodityCreateDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityDetailDto;
import ImportExport.service.warehouseCommodity.WarehouseCommodityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/api/warehouseCommodity")
public class WarehouseCommodityController {
    private final WarehouseCommodityService warehouseCommodityService;

    public WarehouseCommodityController(WarehouseCommodityService warehouseCommodityService) {
        this.warehouseCommodityService = warehouseCommodityService;
    }
    @PostMapping
    public ResponseEntity<WarehouseCommodityDetailDto> create(@RequestBody WarehouseCommodityCreateDto warehouseCommodityCreateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(warehouseCommodityService.createWarehouseCommodity(warehouseCommodityCreateDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<WarehouseCommodityDetailDto> findById(@PathVariable UUID id) {
        return null;
    }


}

