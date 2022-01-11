package ImportExport.service.warehouseCommodity;

import ImportExport.dto.warehouseCommodity.WarehouseCommodityCreateDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityDetailDto;

import java.util.List;
import java.util.UUID;

public interface WarehouseCommodityService {
    WarehouseCommodityDetailDto createWarehouseCommodity(WarehouseCommodityCreateDto warehouseCommodityCreateDto);
    WarehouseCommodityDetailDto findById(UUID id);
    void deleteById(UUID id);
    WarehouseCommodityDetailDto updateWarehouseCommodity (UUID id,WarehouseCommodityCreateDto warehouseCommodityCreateDto);
    List<WarehouseCommodityDetailDto> findAll();
}
