package ImportExport.service;


/*

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
*/

import ImportExport.entity.DetailsImportExport;
import ImportExport.repository.DetailsImportExportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DetailsImportExportServiceImpl {
    private final DetailsImportExportRepository detailsImportExportRepository;
    public List<DetailsImportExport> findAll() {
        return detailsImportExportRepository.findAll();
    }
    public Optional<DetailsImportExport> findById(UUID id) {
        return detailsImportExportRepository.findById(id);

    }
    public DetailsImportExport save(DetailsImportExport stock) {
        return detailsImportExportRepository.save(stock);
    }
    public void deleteById(UUID id) {
        detailsImportExportRepository.deleteById(id);
    }
}