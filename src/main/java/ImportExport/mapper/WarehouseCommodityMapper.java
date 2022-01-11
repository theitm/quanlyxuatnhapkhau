package ImportExport.mapper;

import ImportExport.dto.warehouse.WarehouseCreateDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityBasicDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityCreateDto;
import ImportExport.dto.warehouseCommodity.WarehouseCommodityDetailDto;
import ImportExport.entity.WarehouseCommodityEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WarehouseCommodityMapper {
    WarehouseCommodityEntity fromWarehouseCreateDto(WarehouseCommodityCreateDto warehouseCommodityCreateDto);
    WarehouseCommodityDetailDto fromEntityToDto (WarehouseCommodityEntity warehouseCommodityEntity);
    List<WarehouseCommodityDetailDto> fromListEntityToDto (List<WarehouseCommodityEntity> warehouseCommodityEntities);
    WarehouseCommodityBasicDto fromEntityToBasicDto (WarehouseCommodityEntity warehouseCommodityEntity);
}
