package com.haonguyen.CommodityService.service;


import com.haonguyen.CommodityService.dto.*;
import com.haonguyen.CommodityService.mapper.ICommodityMapper;

import com.haonguyen.CommodityService.mapper.ICommodityMapperImpl;
import com.haonguyen.CommodityService.repository.ICommodityRepository;
import com.mini_project.CoreModule.entity.CommodityEntity;
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


    @Override
      public CommodityEntity addCommodity(CommodityCreateDto commodityCreateDto) {
        if (commodityCreateDto == null) {
            return null;
        }
        ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
        CommodityEntity commodityEntity = iCommodityMapper.fromCreateToEntity(commodityCreateDto);
        iCommodityRepository.saveAndFlush(commodityEntity);
        CommodityCreateDto createDto =iCommodityMapper.toCreateDto(commodityEntity);
        return commodityEntity;
    }

    @Override
    public CommodityUpdateDto updateCommodity(CommodityUpdateDto commodityUpdateDto){
        if (commodityUpdateDto == null){
            return null;
        }
        ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();

        CommodityEntity commodityEntity = iCommodityMapper.fromUpdateToEntity(commodityUpdateDto);

        iCommodityRepository.save(commodityEntity);

        CommodityUpdateDto commodityUpdateDto1 =iCommodityMapper.toUpdateDto(commodityEntity);

        return commodityUpdateDto1;
    }

    @Override
    public void deleteCommodity(UUID id) {
        iCommodityRepository.deleteById(id);
    }

    @Override
    public List<CommoditySearchDto> searchCommodity(String key) {
        if (key==null) {
            ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
            List<CommoditySearchDto> commoditySearchDtos = iCommodityMapper.toSearchDto(iCommodityRepository.findAll());
            return commoditySearchDtos;
        }
        else {

            ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
            List<CommoditySearchDto> commoditySearchDtos = iCommodityMapper.toSearchDto(iCommodityRepository.searchCommodity(key));
            return commoditySearchDtos;
        }
    }

    @Override
    public List<TypeOfCommodityDto> findCommodityByIdTypeOfCommodity(UUID idTypeOfCommodity) {
        ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
        List<TypeOfCommodityDto> typeOfCommodityDto = iCommodityMapper
                .toFindSectorId(iCommodityRepository.findCommodityByIdTypeOfCommodity(idTypeOfCommodity));
        return typeOfCommodityDto;

    }
    @Override
    public TypeAndTaxCommodityAPI getTypeTaxCommodity(UUID idCommodity) {
        return iCommodityRepository.getTypeTaxCommodity(idCommodity);
    }

    @Override
    public CommodityCreateDto CommodityById(UUID id) {
        ICommodityMapper iCommodityMapper= new ICommodityMapperImpl();
        CommodityCreateDto commodityCreateDto = iCommodityMapper.toCreateDto(iCommodityRepository.findById(id).get());
        iCommodityRepository.findById(id).get();
        return commodityCreateDto;
    }
}
