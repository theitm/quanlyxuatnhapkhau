package ImportExport.Mapper;

import ImportExport.DTO.TaxBracketDTO;
import ImportExport.entity.TaxBracketEntity;

public class TaxBracketMapper {
    private static TaxBracketMapper INSTANCE;

    public static TaxBracketMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaxBracketMapper();
        }

        return INSTANCE;
    }

    public TaxBracketEntity toEntity(TaxBracketDTO taxBracketDTO) {
        TaxBracketEntity taxBracketEntity = new TaxBracketEntity();
        taxBracketEntity.setTax_bracket_name(taxBracketDTO.getTax_bracket_name());
        return taxBracketEntity;
    }

    /*public RoleDTO toDTO(Role role) {
        RoleDTO dto = new RoleDTO();
        dto.setName(role.getName());
        dto.setId(role.getId());
        return dto;
    }*/
}
