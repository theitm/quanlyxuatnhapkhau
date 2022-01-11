package ImportExport.mapper;

import ImportExport.dto.warehouse.WarehouseCreateDto;
import ImportExport.dto.warehouse.WarehouseDetailDto;
import ImportExport.entity.WarehouseEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WarehouseMapper {
    WarehouseEntity fromWarehouseCreateDto(WarehouseCreateDto warehouseCreateDto);
    WarehouseDetailDto fromEntityToDto (WarehouseEntity warehouseEntity);
    List<WarehouseDetailDto> fromListEntityToDto(List<WarehouseEntity> warehouseEntities);
}

