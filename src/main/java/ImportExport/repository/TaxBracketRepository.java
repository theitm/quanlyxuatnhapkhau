package ImportExport.repository;

import ImportExport.entity.TaxBracketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface TaxBracketRepository extends JpaRepository<TaxBracketEntity, UUID> {

}
