package ImportExport.service.commodity;

import ImportExport.dto.commodity.CommodityCreateDto;
import ImportExport.dto.commodity.CommodityDetailDto;
import ImportExport.entity.CommodityEntity;
import ImportExport.mapper.CommodityMapper;
import ImportExport.repository.CommodityRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommodityServiceImpl implements CommodityService {
    private final CommodityRepository commodityRepository;
    private final CommodityMapper commodityMapper;

    public CommodityServiceImpl(CommodityRepository commodityRepository, CommodityMapper commodityMapper) {
        this.commodityRepository = commodityRepository;
        this.commodityMapper = commodityMapper;
    }

    public Optional<CommodityEntity> findById(UUID id) {
        return commodityRepository.findById(id);
    }
    public CommodityDetailDto createCommodity(CommodityCreateDto createDto) {
        CommodityEntity commodityEntity = commodityMapper.fromCommodityCreateDto(createDto);
        CommodityEntity commodityEntityCreate = commodityRepository.save(commodityEntity);
        CommodityDetailDto commodityDetaildto = null;
        if(commodityEntityCreate != null) {
            commodityDetaildto = commodityMapper.fromEntityToDetailDto(commodityEntityCreate);
        }
        return commodityDetaildto;
    }
}


