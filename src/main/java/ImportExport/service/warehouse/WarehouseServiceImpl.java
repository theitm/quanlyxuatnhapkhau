package ImportExport.service.warehouse;

import ImportExport.dto.warehouse.WarehouseCreateDto;
import ImportExport.dto.warehouse.WarehouseDetailDto;
import ImportExport.entity.WarehouseEntity;
import ImportExport.mapper.WarehouseMapper;
import ImportExport.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WarehouseServiceImpl implements WarehouseService{
    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository, WarehouseMapper warehouseMapper) {
        this.warehouseRepository = warehouseRepository;
        this.warehouseMapper = warehouseMapper;
    }

    /**
     * Hiện nhà kho theo ID
     * @param id
     * @return
     */
    public WarehouseDetailDto findById(UUID id) {
        WarehouseDetailDto warehouseDetailDto = warehouseMapper.fromEntityToDto(warehouseRepository.getById(id));
        return warehouseDetailDto;
    }

    /**
     * Hiện danh sách nhà kho
     * @return
     */
    public List<WarehouseDetailDto> findAll() {
        return warehouseMapper.fromListEntityToDto(warehouseRepository.findAll());
    }

    /**
     * Tạo nhà kho
     * @param warehouseCreateDto
     * @return
     */
    public WarehouseDetailDto createWarehouse(WarehouseCreateDto warehouseCreateDto) {
        WarehouseEntity warehouseEntity = warehouseMapper.fromWarehouseCreateDto(warehouseCreateDto);
        WarehouseEntity warehouseEntityCreate = warehouseRepository.save(warehouseEntity);
        WarehouseDetailDto warehouseDetailDto = null;
        if(warehouseEntityCreate !=null) {
            warehouseDetailDto = warehouseMapper.fromEntityToDto(warehouseEntityCreate);
        }
        return warehouseDetailDto;
    }

    /**
     * Cập nhật nhà kho
     * @param id
     * @param warehouseCreateDto
     * @return
     */
    public WarehouseDetailDto updateWarehouse(UUID id, WarehouseCreateDto warehouseCreateDto) {
        WarehouseEntity warehouseEntity = warehouseMapper.fromWarehouseCreateDto(warehouseCreateDto);
        warehouseEntity.setId(id);
        warehouseRepository.save(warehouseEntity);
        WarehouseDetailDto warehouseDetailDto = warehouseMapper.fromEntityToDto(warehouseEntity);
        return warehouseDetailDto;
    }

    /**
     * Xóa nhà kho theo ID
     * @param id
     */
    public void deleteById(UUID id) {
        warehouseRepository.deleteById(id);
    }


}
