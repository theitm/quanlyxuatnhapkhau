package ImportExport.service.warehouse;

import ImportExport.dto.warehouse.WarehouseCreateDto;
import ImportExport.dto.warehouse.WarehouseDetailDto;
import ImportExport.entity.WarehouseEntity;
import ImportExport.mapper.WarehouseMapper;
import ImportExport.repository.WarehouseRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class WarehouseServiceImpl implements WarehouseService{
    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository, WarehouseMapper warehouseMapper) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseMapper = warehouseMapper;
    }
    public Optional<WarehouseEntity> findById(UUID id) {
        return warehouseRepository.findById(id);
    }
    public WarehouseDetailDto createWarehouse(WarehouseCreateDto warehouseCreateDto) {
        WarehouseEntity warehouseEntity = warehouseMapper.fromWarehouseCreateDto(warehouseCreateDto);
        WarehouseEntity warehouseEntityCreate = warehouseRepository.save(warehouseEntity);
        WarehouseDetailDto warehouseDetailDto = null;
        if(warehouseEntityCreate !=null) {
            warehouseDetailDto = warehouseMapper.fromEntityToDto(warehouseEntityCreate);
        }
        return warehouseDetailDto;
    }
}
