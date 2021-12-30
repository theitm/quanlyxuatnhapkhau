package ImportExport.service;

import ImportExport.entity.TypeOfCommodityEntity;

import java.util.Optional;
import java.util.UUID;

public interface TypeOfCommodityService {
    Optional<TypeOfCommodityEntity>findById(UUID id);
}
