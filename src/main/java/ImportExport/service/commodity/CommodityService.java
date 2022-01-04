package ImportExport.service.commodity;

import ImportExport.dto.commodity.CommodityCreateDto;
import ImportExport.dto.commodity.CommodityDetailDto;
import ImportExport.entity.CommodityEntity;
import java.util.Optional;
import java.util.UUID;

public interface CommodityService {
    CommodityDetailDto createCommodity(CommodityCreateDto createDto);
    Optional<CommodityEntity> findById(UUID id);
}
