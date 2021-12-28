package ImportExport.repository;

import ImportExport.entity.ImportExportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ImportExportRepository extends JpaRepository<ImportExportEntity, UUID> {

}
