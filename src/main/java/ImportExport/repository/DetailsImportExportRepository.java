package ImportExport.repository;

import ImportExport.entity.DetailsImportExport;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface DetailsImportExportRepository extends JpaRepository<DetailsImportExport, UUID> {

}