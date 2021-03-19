package com.haonguyen.CommodityService.service;



import com.haonguyen.CommodityService.dto.CommodityCreateDto;
import com.haonguyen.CommodityService.dto.CommoditySearchDto;
import com.haonguyen.CommodityService.dto.CommodityUpdateDto;
import com.haonguyen.CommodityService.dto.StyleOfCommodityDto;
import com.haonguyen.CommodityService.mapper.ICommodityMapper;
import com.haonguyen.CommodityService.mapper.ICommodityMapperImpl;
import com.haonguyen.CommodityService.repository.ICommodityRepository;
import com.mini_project.CoreModule.entity.CommodityEntity;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.List;
import java.util.UUID;

=======
>>>>>>> origin/develop

@Service
public class CommodityService implements ICommodityService {
    private final ICommodityRepository iCommodityRepository;
    private final ICommodityMapper commodityMapper;

    public CommodityService(ICommodityRepository commodityRepository,
                            ICommodityMapper commodityMapper) {
        this.iCommodityRepository = commodityRepository;
        this.commodityMapper = commodityMapper;
    }


    @Override
      public CommodityEntity addCommodity(CommodityCreateDto commodityCreateDto) {
        if (commodityCreateDto == null) {
            return null;
        }
        ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
        CommodityEntity commodityEntity = iCommodityMapper.fromCreateToEntity(commodityCreateDto);
        iCommodityRepository.saveAndFlush(commodityEntity);
        return commodityEntity;
    }

    @Override
    public CommodityEntity updateCommodity(CommodityUpdateDto commodityUpdateDto){
        if (commodityUpdateDto == null){
            return null;
        }
        ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();

        CommodityEntity commodityEntity = iCommodityMapper.fromUpdateToEntity(commodityUpdateDto);

        iCommodityRepository.save(commodityEntity);

        return commodityEntity;
    }

    @Override
    public void deleteCommodity(UUID id) {
        iCommodityRepository.deleteById(id);
    }

    @Override
    public List<CommoditySearchDto> searchCommodity(String key) {
        if (key != null) {
            ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
            List<CommoditySearchDto> commoditySearchDtos = iCommodityMapper.toSearchDto(iCommodityRepository.searchCommodity(key));
            return commoditySearchDtos;
        }
        else {
            ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
            List<CommoditySearchDto> commoditySearchDtos = iCommodityMapper.toSearchDto(iCommodityRepository.findAll());
            return commoditySearchDtos;
        }
    }

    @Override
    public List<StyleOfCommodityDto> findCommodityBySectorId(UUID id_sectors) {
        ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
        List<StyleOfCommodityDto> styleOfCommodityDto = iCommodityMapper
                .toFindSectorId(iCommodityRepository.findCommodityById_Sectors(id_sectors));
        return styleOfCommodityDto;

    }
}
