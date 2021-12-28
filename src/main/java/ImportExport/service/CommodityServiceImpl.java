package ImportExport.service;

import javax.transaction.Transactional;

import ImportExport.dto.CommodityDTO;
import ImportExport.entity.Commodity;
import ImportExport.entity.DetailsImportExport;
import ImportExport.mapper.CommodityMapper;
import ImportExport.repository.DetailsImportExportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ImportExport.repository.CommodityRepository;

@Service
@Transactional
public  class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityRepository commodityRepository;
    @Autowired
    private DetailsImportExportRepository detailsImportExportRepository;

    @Override
    public CommodityDTO create(CommodityDTO dto) {
            Commodity commodity = CommodityMapper.getInstance().toEntity(dto);
            List<DetailsImportExport> detailsImportExportList

        return null;
    }
}

