package ImportExport.service;
import ImportExport.entity.DetailsImportExport;
import ImportExport.repository.DetailsImportExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD:quanlyxuatnhapkhau/src/main/java/ImportExport/service/DetailsImportExportService.java


=======
>>>>>>> develop-batch-8-nghia:src/main/java/ImportExport/service/DetailsImportExportService.java
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional

public class DetailsImportExportService {
    @Autowired
    private DetailsImportExportRepository repo;

    public List<DetailsImportExport> listAll() {
        return repo.findAll();
    }

    public void save(DetailsImportExport detailsImportExport) {
        repo.save(detailsImportExport);
    }

    public DetailsImportExport get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
