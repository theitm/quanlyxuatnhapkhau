package ImportExport.service.warehouseCommodity;

import ImportExport.dto.warehouseCommodity.WarehouseCommodityCreateDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityDetailDto;
import ImportExport.entity.WarehouseCommodityEntity;
import ImportExport.mapper.WarehouseCommodityMapper;
import ImportExport.repository.WarehouseCommodityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WarehouseCommodityServiceImpl implements WarehouseCommodityService{
    private final WarehouseCommodityRepository warehouseCommodityRepository;
    private final WarehouseCommodityMapper warehouseCommodityMapper;

    public WarehouseCommodityServiceImpl(WarehouseCommodityRepository warehouseCommodityRepository, WarehouseCommodityMapper warehouseCommodityMapper) {
        this.warehouseCommodityRepository = warehouseCommodityRepository;
        this.warehouseCommodityMapper = warehouseCommodityMapper;
    }

    /**
     * Hiện nhà kho hàng hóa theo ID
     * @param id
     * @return
     */
    public WarehouseCommodityDetailDto findById(UUID id) {
        WarehouseCommodityDetailDto warehouseCommodityDetailDto = warehouseCommodityMapper.fromEntityToDto(warehouseCommodityRepository.getById(id));
        return warehouseCommodityDetailDto;
    }

    /**
     * Hiện danh sách nhà kho hàng hóa
     * @return
     */
    public List<WarehouseCommodityDetailDto> findAll() {
        return warehouseCommodityMapper.fromListEntityToDto(warehouseCommodityRepository.findAll());
    }

    /**
     * Tạo nhà kho hàng hóa
     * @param warehouseCommodityCreateDto
     * @return
     */
    public WarehouseCommodityDetailDto createWarehouseCommodity(WarehouseCommodityCreateDto warehouseCommodityCreateDto) {
        WarehouseCommodityEntity warehouseCommodityEntity = warehouseCommodityMapper.fromWarehouseCreateDto(warehouseCommodityCreateDto);
        WarehouseCommodityEntity warehouseCommodityEntityCreate = warehouseCommodityRepository.save(warehouseCommodityEntity);
        WarehouseCommodityDetailDto warehouseCommodityDetailDto = null;
        if(warehouseCommodityEntityCreate !=null) {
            warehouseCommodityDetailDto = warehouseCommodityMapper.fromEntityToDto(warehouseCommodityEntityCreate);
        }
        return warehouseCommodityDetailDto;
    }

    /**
     * Cập nhật nhà kho hàng hóa
     * @param id
     * @param warehouseCommodityCreateDto
     * @return
     */
    public WarehouseCommodityDetailDto updateWarehouseCommodity (UUID id,WarehouseCommodityCreateDto warehouseCommodityCreateDto) {
        WarehouseCommodityEntity warehouseCommodityEntity = warehouseCommodityMapper.fromWarehouseCreateDto(warehouseCommodityCreateDto);
        warehouseCommodityEntity.setId(id);
        warehouseCommodityRepository.save(warehouseCommodityEntity);
        WarehouseCommodityDetailDto warehouseCommodityDetailDto = warehouseCommodityMapper.fromEntityToDto(warehouseCommodityEntity);
        return warehouseCommodityDetailDto;
    }

    /**
     * Xóa nhà kho hàng hóa theo ID
     * @param id
     */
    public void deleteById(UUID id) {
        warehouseCommodityRepository.deleteById(id);
    }

}
