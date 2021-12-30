package ImportExport.ServiceImpl;
import ImportExport.Mapper.DetailsImportExportMapper;
import ImportExport.entity.DetailsImportExportEntity;
import ImportExport.repository.DetailsImportExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@Transactional

public class DetailsImportExportServiceImpl {
    private final DetailsImportExportRepository detailsImportExportRepository;
    private final DetailsImportExportMapper detailsImportExportMapper;

    public DetailsImportExportServiceImpl(DetailsImportExportRepository detailsImportExportRepository,
                                          DetailsImportExportMapper detailsImportExportMapper){
        this.detailsImportExportRepository = detailsImportExportRepository;
        this.detailsImportExportMapper = detailsImportExportMapper;
    }

    public Optional<DetailsImportExportEntity> findById(UUID id){
        return detailsImportExportRepository.findById(id);
    }

//    @Autowired
//    private DetailsImportExportRepository repo;
//
//    public List<DetailsImportExportEntity> list() {
//        return repo.findAll();
//    }
//
//    public void save(DetailsImportExportEntity detailsImportExportEntity) {
//        repo.save(detailsImportExportEntity);
//    }
//
//    public DetailsImportExportEntity get(UUID id) {
//        return repo.findById(id).get();
//    }
//
//    public void delete(UUID id) {
//        repo.deleteById(id);
//    }
}
