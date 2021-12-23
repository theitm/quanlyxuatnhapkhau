package ImportExport.repository;

import ImportExport.entity.WareHouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WareHouseRepository extends JpaRepository<WareHouseEntity, UUID> {
    void deleteById(UUID id);
    Optional<WareHouseEntity> findById(UUID id);

}
