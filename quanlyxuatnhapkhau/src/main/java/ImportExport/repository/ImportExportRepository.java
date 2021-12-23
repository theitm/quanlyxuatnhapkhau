package ImportExport.repository;

import ImportExport.entity.ImportExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ImportExportRepository extends JpaRepository<ImportExport, UUID> {

}
