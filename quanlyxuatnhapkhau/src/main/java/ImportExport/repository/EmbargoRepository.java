package ImportExport.repository;

import ImportExport.entity.EmbargoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmbargoRepository extends JpaRepository<EmbargoEntity, UUID> {
    void deleteById(UUID id);
    Optional<EmbargoEntity> findById(UUID id);
}
