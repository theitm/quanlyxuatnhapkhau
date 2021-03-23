package com.haonguyen.CommodityService.service;


import com.haonguyen.CommodityService.dto.*;
import com.haonguyen.CommodityService.iservice.ICommodityService;
import com.haonguyen.CommodityService.mapper.ICommodityMapper;
import com.haonguyen.CommodityService.mapper.ICommodityMapperImpl;
import com.haonguyen.CommodityService.repository.ICommodityRepository;
import com.mini_project.CoreModule.entity.CommodityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
      public CommodityCreateDto addCommodity(CommodityCreateDto commodityCreateDto) {
        if (commodityCreateDto == null) {
            return null;
        }
        ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
        CommodityEntity commodityEntity = iCommodityMapper.fromCreateToEntity(commodityCreateDto);
        iCommodityRepository.saveAndFlush(commodityEntity);
        CommodityCreateDto commodityCreateDto1 =iCommodityMapper.toCreateDto(commodityEntity);
        return commodityCreateDto1;
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
    @Autowired
    private RestTemplate restTemplate;
    @Override
    public void deleteCommodity(UUID id) {
        String checkIdCommodityURL = "http://localhost:9002/v1/api/export/check-id-commodity/";
        boolean ABC = restTemplate.getForObject(checkIdCommodityURL + id,Boolean.class);
        iCommodityRepository.deleteById(id);
    }
//    @Override
//    public CommodityEntity del(ItemReceiptDTO list) {
//        String sourceCommodityURL = "http://COMMODITY-SERVICE/commodity/getId/";
//        CommodityDTO resultCommodityDto = restTemplate.getForObject(sourceCommodityURL + list.getIdCommodity(), CommodityDTO.class);
//        CommodityDTOMapper commodityDTOMapper = new CommodityDTOMapperImpl();
//        CommodityEntity commodityEntity = commodityDTOMapper.toCommodityEntity(resultCommodityDto);
//        return commodityEntity;
//    }

    @Override
    public List<CommoditySearchDto> searchCommodity(String key) {
        if (key==null) {

            List<CommoditySearchDto> commoditySearchDtos = iCommodityRepository.findAllSearchCommodity();
            return commoditySearchDtos;
        }
        else {
            List<CommoditySearchDto> commoditySearchDtos =iCommodityRepository.searchCommodity(key);
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
