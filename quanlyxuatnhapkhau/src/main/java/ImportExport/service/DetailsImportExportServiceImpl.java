package ImportExport.service;
import ImportExport.entity.DetailsImportExportEntity;
import ImportExport.repository.DetailsImportExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional

public class DetailsImportExportServiceImpl {
    @Autowired
    private DetailsImportExportRepository repo;

    public List<DetailsImportExportEntity> listAll() {
        return repo.findAll();
    }

    public void save(DetailsImportExportEntity detailsImportExportEntity) {
        repo.save(detailsImportExportEntity);
    }

    public DetailsImportExportEntity get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
