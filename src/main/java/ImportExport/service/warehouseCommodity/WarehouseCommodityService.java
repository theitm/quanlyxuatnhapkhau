package ImportExport.service.warehouseCommodity;

import ImportExport.dto.warehouseCommodity.WarehouseCommodityCreateDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityDetailDto;
import ImportExport.entity.WarehouseCommodityEntity;

import java.util.Optional;
import java.util.UUID;

public interface WarehouseCommodityService {
    WarehouseCommodityDetailDto createWarehouseCommodity(WarehouseCommodityCreateDto warehouseCommodityCreateDto);
    Optional<WarehouseCommodityEntity> findById(UUID id);
}
