package ImportExport.service.typeOfCommodity;

import ImportExport.dto.typeOfCommodity.TypeOfCommodityBasicDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityCreateDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityDetailDto;
import ImportExport.entity.TypeOfCommodityEntity;
import ImportExport.mapper.TypeOfCommodityMapper;
import ImportExport.repository.TypeOfCommodityRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TypeOfCommodityServiceImpl implements TypeOfCommodityService {
    private final TypeOfCommodityRepository typeOfCommodityRepository;
    private final TypeOfCommodityMapper typeOfCommodityMapper;

    public TypeOfCommodityServiceImpl(TypeOfCommodityRepository typeOfCommodityRepository, TypeOfCommodityMapper typeOfCommodityMapper) {
        this.typeOfCommodityRepository = typeOfCommodityRepository;
        this.typeOfCommodityMapper = typeOfCommodityMapper;
    }

    /**
     * Hiện loại hàng hóa theo ID
     * @param id
     * @return
     */
    public TypeOfCommodityDetailDto findById(UUID id) {
       TypeOfCommodityDetailDto typeOfCommodityDetailDto = typeOfCommodityMapper.fromEntityToDto(typeOfCommodityRepository.getById(id));
       return typeOfCommodityDetailDto;
    }

    /**
     * Hiện danh sách loại hàng hóa
     * @return
     */
    public List<TypeOfCommodityDetailDto> findAll() {
        return typeOfCommodityMapper.fromListEntityToDto(typeOfCommodityRepository.findAll());
    }

    /**
     * Tạo loại hàng hóa
     * @param typeOfCommodityCreateDto
     * @return
     */
    public TypeOfCommodityDetailDto createTypeOfCommodity(TypeOfCommodityCreateDto typeOfCommodityCreateDto) {
        TypeOfCommodityEntity typeOfCommodityEntity = typeOfCommodityMapper.fromTypeOfCommodityCreateDto(typeOfCommodityCreateDto);
        TypeOfCommodityEntity typeOfCommodityEntityCreate = typeOfCommodityRepository.save(typeOfCommodityEntity);
        TypeOfCommodityDetailDto typeOfCommodityDetailDto = null;
        if(typeOfCommodityEntityCreate != null) {
            typeOfCommodityDetailDto = typeOfCommodityMapper.fromEntityToDto(typeOfCommodityEntityCreate);
        }
        return typeOfCommodityDetailDto;
    }

    /**
     * Cập nhật loại hàng hóa
     * @param id
     * @param typeOfCommodityCreateDto
     * @return
     */
    public TypeOfCommodityDetailDto updateType(UUID id, TypeOfCommodityCreateDto typeOfCommodityCreateDto) {
        TypeOfCommodityEntity typeOfCommodityEntity = typeOfCommodityMapper.fromTypeOfCommodityCreateDto(typeOfCommodityCreateDto);
        typeOfCommodityEntity.setId(id);
        typeOfCommodityRepository.save(typeOfCommodityEntity);
        TypeOfCommodityDetailDto typeOfCommodityDetailDto = typeOfCommodityMapper.fromEntityToDto(typeOfCommodityEntity);
        return typeOfCommodityDetailDto;
    }

    /**
     * Xóa loại hàng hóa theo ID
     * @param id
     */
    public void deleteById(UUID id) {
        typeOfCommodityRepository.deleteById(id);
    }

    public List<TypeOfCommodityBasicDto> findAllTypeOfCommodity() {
       return typeOfCommodityMapper.fromEntityListBasicDto(typeOfCommodityRepository.findAll());
    }

}
