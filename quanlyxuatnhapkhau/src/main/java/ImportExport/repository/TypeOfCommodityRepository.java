package ImportExport.repository;

import ImportExport.entity.TypeOfCommodityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TypeOfCommodityRepository extends JpaRepository<TypeOfCommodityEntity, UUID> {

}