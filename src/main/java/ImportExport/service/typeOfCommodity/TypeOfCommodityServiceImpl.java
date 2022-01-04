package ImportExport.service.typeOfCommodity;

import ImportExport.dto.typeOfCommodity.TypeOfCommodityCreateDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityDetailDto;
import ImportExport.entity.TypeOfCommodityEntity;
import ImportExport.mapper.TypeOfCommodityMapper;
import ImportExport.repository.TypeOfCommodityRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service

public class TypeOfCommodityServiceImpl implements TypeOfCommodityService {
    private final TypeOfCommodityRepository typeOfCommodityRepository;
    private final TypeOfCommodityMapper typeOfCommodityMapper;

    public TypeOfCommodityServiceImpl(TypeOfCommodityRepository typeOfCommodityRepository, TypeOfCommodityMapper typeOfCommodityMapper) {
        this.typeOfCommodityRepository = typeOfCommodityRepository;
        this.typeOfCommodityMapper = typeOfCommodityMapper;
    }
    public Optional<TypeOfCommodityEntity> findById(UUID id) {
        return typeOfCommodityRepository.findById(id);
    }
    public TypeOfCommodityDetailDto createTypeOfCommodity(TypeOfCommodityCreateDto typeOfCommodityCreateDto) {
        TypeOfCommodityEntity typeOfCommodityEntity = typeOfCommodityMapper.fromTypeOfCommodityCreateDto(typeOfCommodityCreateDto);
        TypeOfCommodityEntity typeOfCommodityEntityCreate = typeOfCommodityRepository.save(typeOfCommodityEntity);
        TypeOfCommodityDetailDto typeOfCommodityDetailDto = null;
        if(typeOfCommodityEntityCreate != null) {
            typeOfCommodityDetailDto = typeOfCommodityMapper.fromEntityToDto(typeOfCommodityEntityCreate);
        }
        return typeOfCommodityDetailDto;
    }
}
