package ImportExport.repository;

import ImportExport.entity.DetailsImportExportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DetailsImportExportRepository extends JpaRepository<DetailsImportExportEntity, UUID> {

}
