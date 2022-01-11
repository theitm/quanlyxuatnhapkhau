package ImportExport.service.commodity;

import ImportExport.dto.commodity.CommodityCreateDto;
import ImportExport.dto.commodity.CommodityDetailDto;

import java.util.List;
import java.util.UUID;

public interface CommodityService {
    CommodityDetailDto createCommodity(CommodityCreateDto createDto);
    CommodityDetailDto findById(UUID id);
    List<CommodityDetailDto> findAll();
    CommodityDetailDto updateCommodity(UUID id , CommodityCreateDto commodityCreateDto);
    void deleteById(UUID id);

}
