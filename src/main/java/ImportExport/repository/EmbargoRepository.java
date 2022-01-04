package ImportExport.repository;

import ImportExport.entity.EmbargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface EmbargoRepository extends JpaRepository<EmbargoEntity, UUID> {

}
