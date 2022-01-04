package ImportExport.service.warehouseCommodity;

import ImportExport.dto.warehouseCommodity.WarehouseCommodityCreateDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityDetailDto;
import ImportExport.entity.WarehouseCommodityEntity;
import ImportExport.mapper.WarehouseCommodityMapper;
import ImportExport.repository.WarehouseCommodityRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class WarehouseCommodityServiceImpl implements WarehouseCommodityService{
    private final WarehouseCommodityRepository warehouseCommodityRepository;
    private final WarehouseCommodityMapper warehouseCommodityMapper;

    public WarehouseCommodityServiceImpl(WarehouseCommodityRepository warehouseCommodityRepository, WarehouseCommodityMapper warehouseCommodityMapper) {
        this.warehouseCommodityRepository = warehouseCommodityRepository;
        this.warehouseCommodityMapper = warehouseCommodityMapper;
    }
    public Optional<WarehouseCommodityEntity> findById(UUID id) {
        return warehouseCommodityRepository.findById(id);
    }
    public WarehouseCommodityDetailDto createWarehouseCommodity(WarehouseCommodityCreateDto warehouseCommodityCreateDto) {
        WarehouseCommodityEntity warehouseCommodityEntity = warehouseCommodityMapper.fromWarehouseCreateDto(warehouseCommodityCreateDto);
        WarehouseCommodityEntity warehouseCommodityEntityCreate = warehouseCommodityRepository.save(warehouseCommodityEntity);
        WarehouseCommodityDetailDto warehouseCommodityDetailDto = null;
        if(warehouseCommodityEntityCreate !=null) {
            warehouseCommodityDetailDto = warehouseCommodityMapper.fromEntityToDto(warehouseCommodityEntityCreate);
        }
        return warehouseCommodityDetailDto;
    }
}
