package service;

import entity.DetailsImportExport;
import org.springframework.beans.factory.annotation.Autowired;
import repository.DetailsImportExportRepository;
import java.util.List;
import java.util.UUID;

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
