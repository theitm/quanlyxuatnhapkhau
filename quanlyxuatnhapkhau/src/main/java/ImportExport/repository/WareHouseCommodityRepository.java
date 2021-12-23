package ImportExport.repository;

import ImportExport.entity.WareHouseCommodityEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface WareHouseCommodityRepository extends JpaRepository<WareHouseCommodityEntity, UUID> {
    void deleteById(UUID id);
    Optional<WareHouseCommodityEntity> findById(UUID id);

}
