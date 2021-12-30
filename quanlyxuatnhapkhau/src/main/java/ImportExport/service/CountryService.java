package ImportExport.service;

import ImportExport.DTO.CountryDTO;
import ImportExport.entity.CountryEntity;

import java.util.Optional;
import java.util.UUID;

public interface CountryService {
    Optional<CountryEntity> findById(UUID id);
}
