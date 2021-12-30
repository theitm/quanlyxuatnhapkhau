package ImportExport.service;

import ImportExport.DTO.Commodity.CommodityCreateDto;
import ImportExport.DTO.Commodity.CommodityDTO;
import ImportExport.entity.CommodityEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommodityService {
    CommodityDTO createCommodity(CommodityCreateDto createDto);
    Optional<CommodityEntity> findById(UUID id);
}
