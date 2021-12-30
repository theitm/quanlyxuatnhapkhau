package ImportExport.repository;

import ImportExport.entity.CountryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CountryRepository extends JpaRepository <CountryEntity, UUID>{
//    void deleteById(UUID id);
//    Optional<CountryEntity> findById(UUID id);
}
