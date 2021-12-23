package ImportExport.repository;

import ImportExport.entity.EmbargoEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface EmbargoRepository extends JpaRepository<EmbargoEntity, UUID> {
    void deleteById(UUID id);
    Optional<EmbargoEntity> findById(UUID id);
}
