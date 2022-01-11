package ImportExport.service.taxBracket;

import ImportExport.dto.taxBracket.TaxBracketCreateDto;
import ImportExport.dto.taxBracket.TaxBracketDetailDto;
import ImportExport.entity.TaxBracketEntity;
import ImportExport.mapper.TaxBracketMapper;
import ImportExport.repository.TaxBracketRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TaxBracketServiceImpl implements TaxBracketService {
    private final TaxBracketRepository taxBracketRepository;
    private final TaxBracketMapper taxBracketMapper;

    public TaxBracketServiceImpl(TaxBracketRepository taxBracketRepository, TaxBracketMapper taxBracketMapper) {
        this.taxBracketRepository = taxBracketRepository;
        this.taxBracketMapper = taxBracketMapper;
    }

    /**
     * Hiện khung thuế theo ID
     * @param id
     * @return
     */
    public TaxBracketDetailDto findById(UUID id) {
        TaxBracketDetailDto taxBracketDetailDto = taxBracketMapper.fromEntityToDto(taxBracketRepository.getById(id));
        return taxBracketDetailDto;
    }

    /**
     * Hiện danh sách khung thuế
     * @return
     */
    public List<TaxBracketDetailDto> findAll() {
        return taxBracketMapper.fromListEntityToDto(taxBracketRepository.findAll());
    }

    /**
     * Tạo khung thuế
     * @param taxBracketCreateDto
     * @return
     */
    public TaxBracketDetailDto createTaxBracket (TaxBracketCreateDto taxBracketCreateDto) {
        TaxBracketEntity taxBracketEntity = taxBracketMapper.fromTaxBracketCreateDto(taxBracketCreateDto);
        TaxBracketEntity taxBracketEntityCreate = taxBracketRepository.save(taxBracketEntity);
        TaxBracketDetailDto taxBracketDetailDto = null;
        if(taxBracketEntityCreate != null) {
            taxBracketDetailDto = taxBracketMapper.fromEntityToDto(taxBracketEntityCreate);
        }
        return taxBracketDetailDto;
    }

    /**
     * Cập nhập khung thuế
     * @param id
     * @param taxBracketCreateDto
     * @return
     */
    public TaxBracketDetailDto updateTaxBracket (UUID id, TaxBracketCreateDto taxBracketCreateDto) {
        TaxBracketEntity taxBracketEntity = taxBracketMapper.fromTaxBracketCreateDto(taxBracketCreateDto);
        taxBracketEntity.setId(id);
        taxBracketRepository.save(taxBracketEntity);
        TaxBracketDetailDto taxBracketDetailDto = taxBracketMapper.fromEntityToDto(taxBracketEntity);
        return taxBracketDetailDto;
    }

    /**
     * Xóa khung thuế theo ID
     * @param id
     */
    public void deleteById(UUID id) {
        taxBracketRepository.deleteById(id);
    }
}
