package ImportExport.repository;

import ImportExport.entity.WareHouseCommodityEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WareHouseCommodityRepository extends JpaRepository<WareHouseCommodityEntity, UUID> {
    void deleteById(UUID id);
    Optional<WareHouseCommodityEntity> findById(UUID id);

}
