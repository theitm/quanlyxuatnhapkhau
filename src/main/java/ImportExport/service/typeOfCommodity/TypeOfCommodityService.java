package ImportExport.service.typeOfCommodity;

import ImportExport.dto.typeOfCommodity.TypeOfCommodityBasicDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityCreateDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityDetailDto;
import ImportExport.entity.TypeOfCommodityEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TypeOfCommodityService {
    TypeOfCommodityDetailDto createTypeOfCommodity(TypeOfCommodityCreateDto typeOfCommodityCreateDto);
    TypeOfCommodityDetailDto findById(UUID id);
    void deleteById(UUID id);
    TypeOfCommodityDetailDto updateType(UUID id, TypeOfCommodityCreateDto typeOfCommodityCreateDto);
    List<TypeOfCommodityDetailDto> findAll();
    List<TypeOfCommodityBasicDto> findAllTypeOfCommodity();
}
