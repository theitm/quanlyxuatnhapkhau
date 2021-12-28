package ImportExport.service;
import ImportExport.dto.DetailsImportExportDTO;
import ImportExport.entity.DetailsImportExport;
import ImportExport.repository.DetailsImportExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional

public class DetailsImportExportServiceImpl implements  DetailsImportExportService{
    @Autowired
    private DetailsImportExportRepository detailsImportExportRepository;

    @Override
    public DetailsImportExportDTO create(DetailsImportExportDTO dto) {
        DetailsImportExport detailsImportExport = new DetailsImportExport();
        return null;
    }
}
