package ImportExport.service;

import ImportExport.entity.EmbargoEntity;

import java.util.Optional;
import java.util.UUID;

public interface EmbargoService {
    Optional<EmbargoEntity>findById(UUID id);
}
