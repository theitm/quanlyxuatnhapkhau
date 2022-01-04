package ImportExport.mapper;

import ImportExport.dto.warehouse.WarehouseCreateDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityCreateDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityDetailDto;
import ImportExport.entity.WarehouseCommodityEntity;
import org.mapstruct.Mapper;

@Mapper
public interface WarehouseCommodityMapper {
    WarehouseCommodityEntity fromWarehouseCreateDto(WarehouseCommodityCreateDto warehouseCommodityCreateDto);
    WarehouseCommodityDetailDto fromEntityToDto (WarehouseCommodityEntity warehouseCommodityEntity);
}
