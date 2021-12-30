package ImportExport.service;

import ImportExport.entity.WareHouseEntity;

import java.util.Optional;
import java.util.UUID;

public interface WareHouseService {
    Optional<WareHouseEntity>findById(UUID id);
}
