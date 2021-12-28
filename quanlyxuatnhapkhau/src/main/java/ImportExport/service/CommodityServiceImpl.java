package ImportExport.service;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import ImportExport.DTO.CommodityDTO;
import ImportExport.Mapper.CommodityMapper;
import ImportExport.Mapper.CommodityMapperS;
import ImportExport.entity.CommodityEntity;
import ImportExport.repository.CommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityRepository repo;

    @Autowired
    private  CommodityMapper commodityMapper;

    public CommodityServiceImpl(CommodityRepository commodityRepository,CommodityMapper commodityMapper){
        this.repo = commodityRepository;
        this.commodityMapper = commodityMapper;
    }

    public List<CommodityMapperS> list() {
        return commodityMapper.();
    }

    public void save(CommodityEntity commodityEntity) {
        repo.save(commodityEntity);
    }

    public CommodityEntity get(UUID id) {
        return repo.findById(id).get();
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
    @Override
    public CommodityDTO create(CommodityDTO dto) {
        CommodityEntity commodityEntity = new CommodityEntity();
        commodityEntity.setCommodityName(dto.getCommodityName());
        return CommodityMapper.getINSTANCE().toDTO(repo.save(commodityEntity));
    }
    /*@Override
    public List<CommodityDTO> findAllCommodity() {
        return repo.findAll().stream().
                map(commodityMapper::commodityToCommodityDTO).collect(Collectors.toList());

    }*/

}
