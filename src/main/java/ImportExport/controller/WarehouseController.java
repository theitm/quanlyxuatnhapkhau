package ImportExport.controller;

import ImportExport.dto.taxBracket.TaxBracketCreateDto;
import ImportExport.dto.warehouse.WarehouseCreateDto;
import ImportExport.dto.warehouse.WarehouseDetailDto;
import ImportExport.service.warehouse.WarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/api/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }
    @PostMapping
    public ResponseEntity<WarehouseDetailDto> create(@RequestBody WarehouseCreateDto warehouseCreateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(warehouseService.createWarehouse(warehouseCreateDto));

    }
    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDetailDto> findById(@PathVariable UUID id) {
        return null;
    }
}
