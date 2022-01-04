package ImportExport.service.warehouse;

import ImportExport.dto.warehouse.WarehouseCreateDto;
import ImportExport.dto.warehouse.WarehouseDetailDto;
import ImportExport.entity.WarehouseEntity;

import java.util.Optional;
import java.util.UUID;

public interface WarehouseService {
    WarehouseDetailDto createWarehouse(WarehouseCreateDto warehouseCreateDto);
    Optional<WarehouseEntity> findById(UUID id);

}
