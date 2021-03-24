package com.haonguyen.CommodityService.service;



import com.haonguyen.CommodityService.dto.*;
import com.haonguyen.CommodityService.iservice.ICommodityService;
import com.haonguyen.CommodityService.mapper.ICommodityMapper;
import com.haonguyen.CommodityService.mapper.ICommodityMapperImpl;
import com.haonguyen.CommodityService.repository.ICommodityRepository;
import com.mini_project.CoreModule.entity.CommodityEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.UUID;


@Service
public class CommodityService implements ICommodityService {
    private final ICommodityRepository iCommodityRepository;
    private final ICommodityMapper commodityMapper;
    private final RestTemplate restTemplate;

    public CommodityService(ICommodityRepository commodityRepository,
                            ICommodityMapper commodityMapper, RestTemplate restTemplate) {
        this.iCommodityRepository = commodityRepository;
        this.commodityMapper = commodityMapper;
        this.restTemplate = restTemplate;
    }

    /**
     * xoa hang theo dieu kien,ton kho,khong co tron phieu nhap
     */
    @Override
    public void deleteCommodity(UUID id) {
        Double commodityInWarehouse = iCommodityRepository.checkCommodityInWarehouseById(id).getInventoryNumber();
        String checkIdCommodityURL = "http://localhost:8112/v1/api/export/check-id-commodity/";
        String ABC = restTemplate.getForObject(checkIdCommodityURL + id,String.class);
        if(ABC.equals("true") && commodityInWarehouse == 0 )
            iCommodityRepository.deleteById(id);
        else {

        }

    }
    /**
     *tim kiem da dieu kien
     */
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

    /**
     *Them hang
     */
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

    /**
     *Cap nhat hang
     */
    @Override
    public CommodityUpdateDto updateCommodity(CommodityUpdateDto commodityUpdateDto, UUID idCommodity){
        if (commodityUpdateDto == null){
            return null;
        }
        commodityUpdateDto.setId(idCommodity);
        ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
        CommodityEntity commodityEntity = iCommodityMapper.fromUpdateToEntity(commodityUpdateDto);
        iCommodityRepository.save(commodityEntity);
        CommodityUpdateDto commodityUpdateDto1 =iCommodityMapper.toUpdateDto(commodityEntity);
        return commodityUpdateDto1;
    }

    /**
     *Lay thong tin theo loai hang
     */
    @Override
    public List<TypeOfCommodityDto> findCommodityByIdTypeOfCommodity(UUID idTypeOfCommodity) {
        ICommodityMapper iCommodityMapper = new ICommodityMapperImpl();
        List<TypeOfCommodityDto> typeOfCommodityDto = iCommodityMapper
                .toFindSectorId(iCommodityRepository.findCommodityByIdTypeOfCommodity(idTypeOfCommodity));
        return typeOfCommodityDto;
    /**
     * lay thong tin thue
     */
    }
    @Override
    public TypeAndTaxCommodityAPI getTypeTaxCommodity(UUID idCommodity) {
        if (idCommodity!= null) {
            TypeAndTaxCommodityAPI typeAndTaxCommodityAPI = iCommodityRepository.getTypeTaxCommodity(idCommodity);
            return typeAndTaxCommodityAPI;
        }
        else
            return null;
    }
    /**
     *Lay thong tin theo id
     */
    @Override
    public CommodityCreateDto CommodityById(UUID id) {
        ICommodityMapper iCommodityMapper= new ICommodityMapperImpl();
        CommodityCreateDto commodityCreateDto = iCommodityMapper.toCreateDto(iCommodityRepository.findById(id).get());
        iCommodityRepository.findById(id).get();
        return commodityCreateDto;
    }
}
