package repository;
import entity.Commodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommodityRepository extends JpaRepository<Commodity, UUID> {

}
