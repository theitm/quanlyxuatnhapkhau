package ImportExport.repository;

import ImportExport.entity.WareHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface WareHouseRepository extends JpaRepository<WareHouseEntity, UUID> {
    void deleteById(UUID id);
    Optional<WareHouseEntity> findById(UUID id);

}
