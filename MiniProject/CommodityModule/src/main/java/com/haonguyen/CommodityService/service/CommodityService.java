package com.haonguyen.CommodityService.service;



import com.haonguyen.CommodityService.dto.CommodityCreateDto;
import com.haonguyen.CommodityService.mapper.ICommodityMapper;
import com.haonguyen.CommodityService.repository.ICommodityRepository;
import com.mini_project.Coremodule.entity.CommodityEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CommodityService implements ICommodityService {
    private final ICommodityRepository iCommodityRepository;
    private final ICommodityMapper commodityMapper;

    public CommodityService(ICommodityRepository commodityRepository,
                            ICommodityMapper commodityMapper) {
        this.iCommodityRepository = commodityRepository;
        this.commodityMapper = commodityMapper;
    }


//    @Override
//    public CommodityEntity updateCommodity(CommodityEntity commodityEntity) {
//
//     return iCommodityRepository.save(commodityEntity);
//    }
//
//    @Override
//    public CommodityEntity addCommodity(CommodityEntity commodityEntity) {
//        return iCommodityRepository.save(commodityEntity);
//    }
//
//    @Override
//    public void deleteCommodity(UUID id) {
//        iCommodityRepository.deleteById(id);
//    }
//
//    @Override
//    public CommodityEntity findCommodityById(UUID id) {
//        return this.commodityMapper.toCreateDto(this.iCommodityRepository.findCommodityById(id));
//
//    }
//
//    @Override
//    public List<CommodityEntity> findCommodityById_Sectors(UUID id_Sectors) {
//        return iCommodityRepository.findCommodityById_Sectors(id_Sectors);
//
//    }

    @Override
    public Object save(CommodityCreateDto commodityCreateDto) {
      CommodityEntity commodityEntity =this.iCommodityRepository.save(this.commodityMapper.fromCreateToEntity(commodityCreateDto));
      return this.commodityMapper.toCreateDto(commodityEntity);
    }


}
