package ImportExport.service;

import ImportExport.entity.WareHouseCommodityEntity;
import ImportExport.repository.WareHouseCommodityRepository;

import java.util.Optional;
import java.util.UUID;

public interface WareHouseCommodityService {
    Optional<WareHouseCommodityEntity>findById(UUID id);
}
