package ImportExport.service.warehouse;

import ImportExport.dto.warehouse.WarehouseCreateDto;
import ImportExport.dto.warehouse.WarehouseDetailDto;

import java.util.List;
import java.util.UUID;

public interface WarehouseService {
    WarehouseDetailDto createWarehouse(WarehouseCreateDto warehouseCreateDto);
    WarehouseDetailDto findById(UUID id);
    void deleteById(UUID id);
    List<WarehouseDetailDto> findAll();
    WarehouseDetailDto updateWarehouse(UUID id, WarehouseCreateDto warehouseCreateDto);



}
