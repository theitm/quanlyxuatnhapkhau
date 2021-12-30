package ImportExport.ServiceImpl;

import ImportExport.Mapper.ImportExportMapper;
import ImportExport.entity.ImportExportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.ImportExportRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@Transactional

public class ImportExportServiceImpl {

    private final ImportExportRepository importExportRepository;
    private final ImportExportMapper importExportMapper;

    public ImportExportServiceImpl(ImportExportRepository importExportRepository,
                                   ImportExportMapper importExportMapper){
        this.importExportRepository = importExportRepository;
        this.importExportMapper = importExportMapper;
    }

    public Optional<ImportExportEntity>findById(UUID id){
        return importExportRepository.findById(id);
    }

//    @Autowired
//    private ImportExportRepository repo;
//
//    public List<ImportExportEntity> list() {
//        return repo.findAll();
//    }
//
//    public void save(ImportExportEntity importExportEntity) {
//        repo.save(importExportEntity);
//    }
//
//    public ImportExportEntity get(UUID id) {
//        return repo.findById(id).get();
//    }
//
//    public void delete(UUID id) {
//        repo.deleteById(id);
//    }
}
