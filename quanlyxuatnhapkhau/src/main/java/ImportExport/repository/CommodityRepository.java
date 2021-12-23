package ImportExport.repository;

import ImportExport.entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CommodityRepository extends JpaRepository<Commodity, UUID> {

}
