package ImportExport.ServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import ImportExport.DTO.Commodity.CommodityCreateDto;
import ImportExport.DTO.Commodity.CommodityDTO;
import ImportExport.Mapper.CommodityMapper;
import ImportExport.entity.CommodityEntity;
import ImportExport.entity.CountryEntity;
import ImportExport.repository.CommodityRepository;
import ImportExport.repository.CountryRepository;
import ImportExport.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService{
    private final CommodityRepository commodityRepository;
    private final CommodityMapper commodityMapper;

    public CommodityServiceImpl(CommodityRepository commodityRepository,
                                CommodityMapper commodityMapper) {
        this.commodityRepository = commodityRepository;
        this.commodityMapper = commodityMapper;
    }

    public Optional<CommodityEntity> findById(UUID id) {
        return commodityRepository.findById(id);
    }

    public CommodityEntity save(CommodityEntity stock) {
        return commodityRepository.save(stock);
    }

    public CommodityDTO createCommodity(CommodityCreateDto createDto) {
        CommodityEntity commodityEntity = commodityMapper.fromCommodityCreateDto(createDto);
        CommodityEntity commodityEntityCreate = commodityRepository.save(commodityEntity);
        CommodityDTO commodityDTO = null;
        if(commodityEntityCreate != null) {
            commodityDTO = commodityMapper.fromEntityToDetailDto(commodityEntityCreate);
        }
        return commodityDTO;
    }

}
