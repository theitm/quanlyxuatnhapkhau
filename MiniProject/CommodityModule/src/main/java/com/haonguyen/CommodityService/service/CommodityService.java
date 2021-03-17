package com.haonguyen.CommodityService.service;



import com.haonguyen.CommodityService.dto.CommodityCreateDto;
import com.haonguyen.CommodityService.mapper.ICommodityMapper;
import com.haonguyen.CommodityService.mapper.ICommodityMapperImpl;
import com.haonguyen.CommodityService.repository.ICommodityRepository;
import com.mini_project.Coremodule.entity.CommodityEntity;
import org.springframework.stereotype.Service;

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


//
//    @Override
//    public void deleteCommodity(UUID id) {
//        iCommodityRepository.deleteById(id);
//    }
//
//    @Override
//    public CommodityEntity findCommodityById(UUID id) {
//        return iCommodityRepository.findCommodityById(id);
//
//    }

//
//    @Override
//    public List<CommodityEntity> findCommodityById_Sectors(UUID id_Sectors) {
//        return iCommodityRepository.findCommodityById_Sectors(id_Sectors);
//
//    }



}
