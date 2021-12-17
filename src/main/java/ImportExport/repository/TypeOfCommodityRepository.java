package ImportExport.repository;

import ImportExport.entity.TypeOfCommodity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TypeOfCommodityRepository extends JpaRepository<TypeOfCommodity, UUID> {

}