package ImportExport.service.typeOfCommodity;

import ImportExport.dto.typeOfCommodity.TypeOfCommodityCreateDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityDetailDto;
import ImportExport.entity.TypeOfCommodityEntity;

import java.util.Optional;
import java.util.UUID;

public interface TypeOfCommodityService {
    TypeOfCommodityDetailDto createTypeOfCommodity(TypeOfCommodityCreateDto typeOfCommodityCreateDto);
    Optional<TypeOfCommodityEntity> findById(UUID id);
}
