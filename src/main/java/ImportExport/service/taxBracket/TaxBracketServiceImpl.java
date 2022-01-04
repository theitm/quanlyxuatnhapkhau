package ImportExport.service.taxBracket;

import ImportExport.dto.taxBracket.TaxBracketCreateDto;
import ImportExport.dto.taxBracket.TaxBracketDetailDto;
import ImportExport.entity.TaxBracketEntity;
import ImportExport.mapper.TaxBracketMapper;
import ImportExport.repository.TaxBracketRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TaxBracketServiceImpl implements TaxBracketService {
    private final TaxBracketRepository taxBracketRepository;
    private final TaxBracketMapper taxBracketMapper;

    public TaxBracketServiceImpl(TaxBracketRepository taxBracketRepository, TaxBracketMapper taxBracketMapper) {
        this.taxBracketRepository = taxBracketRepository;
        this.taxBracketMapper = taxBracketMapper;
    }
    public Optional<TaxBracketEntity> findById(UUID id) {
        return taxBracketRepository.findById(id);
    }
    public TaxBracketDetailDto createTaxBracket (TaxBracketCreateDto taxBracketCreateDto) {
        TaxBracketEntity taxBracketEntity = taxBracketMapper.fromTaxBracketCreateDto(taxBracketCreateDto);
        TaxBracketEntity taxBracketEntityCreate = taxBracketRepository.save(taxBracketEntity);
        TaxBracketDetailDto taxBracketDetailDto = null;
        if(taxBracketEntityCreate != null) {
            taxBracketDetailDto = taxBracketMapper.fromEntityToDto(taxBracketEntityCreate);
        }
        return taxBracketDetailDto;
    }
}
