package ImportExport.repository;

import ImportExport.entity.TypeOfCommodity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TypeOfCommodityRepository extends JpaRepository<TypeOfCommodity, UUID> {

}
