package ImportExport.service;

import ImportExport.entity.ImportExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.ImportExportRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional

public class ImportExportServiceImpl {
    @Autowired
    private ImportExportRepository repo;

    public List<ImportExport> listAll() {
        return repo.findAll();
    }

    public void save(ImportExport importExport) {
        repo.save(importExport);
    }

    public ImportExport get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
