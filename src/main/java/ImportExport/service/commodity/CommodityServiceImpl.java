package ImportExport.service.commodity;

import ImportExport.dto.commodity.CommodityCreateDto;
import ImportExport.dto.commodity.CommodityDetailDto;
import ImportExport.entity.CommodityEntity;
import ImportExport.mapper.CommodityMapper;
import ImportExport.repository.CommodityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CommodityServiceImpl implements CommodityService {
    private final CommodityRepository commodityRepository;
    private final CommodityMapper commodityMapper;

    public CommodityServiceImpl(CommodityRepository commodityRepository, CommodityMapper commodityMapper) {
        this.commodityRepository = commodityRepository;
        this.commodityMapper = commodityMapper;
    }

    /**
     * Hiện hàng hóa theo ID
     *
     * @param id
     * @return
     */
    public CommodityDetailDto findById(UUID id) {
        CommodityDetailDto commodityDetailDto = commodityMapper.fromEntityToDetailDto(commodityRepository.getById(id));
        return commodityDetailDto;
    }

    /**
     * Hiện ra danh sách hàng hóa
     *
     * @return
     */
    public List<CommodityDetailDto> findAll() {
        return commodityMapper.fromEntityToDto(commodityRepository.findAll());
    }

    /**
     * Tạo một hàng hóa
     *
     * @param createDto
     * @return
     */
    public CommodityDetailDto createCommodity(CommodityCreateDto createDto) {
        CommodityEntity commodityEntity = commodityMapper.fromCommodityCreateDto(createDto);
        CommodityEntity commodityEntityCreate = commodityRepository.save(commodityEntity);
        CommodityDetailDto commodityDetaildto = null;
        if (commodityEntityCreate != null) {
            commodityDetaildto = commodityMapper.fromEntityToDetailDto(commodityEntityCreate);
        }
        return commodityDetaildto;
    }

    /**
     * Cập nhập hàng hóa
     *
     * @param id
     * @param commodityCreateDto
     * @return
     */
    public CommodityDetailDto updateCommodity(UUID id, CommodityCreateDto commodityCreateDto) {
        CommodityEntity commodityEntity = commodityMapper.fromCommodityCreateDto(commodityCreateDto);
        commodityEntity.setId(id);
        commodityRepository.save(commodityEntity);
        CommodityDetailDto commodityDetailDto = commodityMapper.fromEntityToDetailDto(commodityEntity);
        return commodityDetailDto;
    }

    /**
     * Xóa hàng hóa theo Id
     *
     * @param id
     */
    public void deleteById(UUID id) {
        commodityRepository.deleteById(id);
    }

}


