package ImportExport.repository;

import ImportExport.entity.CountryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CountryRepository extends JpaRepository <CountryEntity, UUID>{
    void deleteById(UUID id);
    Optional<CountryEntity> findById(UUID id);
}
