package ImportExports.repository;

import ImportExports.entity.ImportExport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ImportExportRepository extends JpaRepository<ImportExport, UUID> {

}
