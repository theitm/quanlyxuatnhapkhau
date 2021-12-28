package ImportExport.service;

/*import javax.transaction.Transactional;

import ImportExport.dto.CommodityDTO;
import ImportExport.entity.Commodity;
import ImportExport.entity.DetailsImportExport;
import ImportExport.mapper.CommodityMapper;
import ImportExport.repository.DetailsImportExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.CommodityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public  class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityRepository commodityRepository;
    @Autowired
    private DetailsImportExportRepository detailsImportExportRepository;

    @Override
    public List<CommodityDTO> findAll() {
        return commodityRepository.findAll().stream()
                .map(commodity -> CommodityMapper.getInstance().toDTO(commodity))
                .collect(Collectors.toList());
    }
}
*/

import ImportExport.entity.Commodity;
import ImportExport.repository.CommodityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CommodityServiceImpl {
    private final CommodityRepository commodityRepository;
    public List<Commodity> findAll() {
        return commodityRepository.findAll();
    }
    public Optional<Commodity> findById(UUID id) {
        return commodityRepository.findById(id);
    }
    public Commodity save(Commodity stock) {
        return commodityRepository.save(stock);
    }
    public void deleteById ( UUID id) {
            commodityRepository.deleteById(id);
    }
}


