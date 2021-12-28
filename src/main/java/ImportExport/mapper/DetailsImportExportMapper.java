package ImportExport.mapper;

import ImportExport.dto.DetailsImportExportDTO;
import ImportExport.entity.DetailsImportExport;
import org.mapstruct.Mapper;

import java.util.List;

/*import ImportExport.dto.DetailsImportExportDTO;
import ImportExport.entity.Commodity;
import ImportExport.entity.DetailsImportExport;

import java.util.stream.Collectors;

public class DetailsImportExportMapper {
    private static DetailsImportExportMapper INSTANCE;
    public static DetailsImportExportMapper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DetailsImportExportMapper();
        }
        return INSTANCE;
    }
    public DetailsImportExport toEntity(DetailsImportExportDTO detailsImportExportDTO) {
        DetailsImportExport detailsImportExport = new DetailsImportExport();
        detailsImportExport.setIdImportExport(detailsImportExportDTO.getIdImportExport());
        detailsImportExport.setIdCommodity(detailsImportExportDTO.getIdCommodity());
        detailsImportExport.setId(detailsImportExportDTO.getId());
        detailsImportExport.setDescription(detailsImportExportDTO.getDescription());
        detailsImportExport.setQuantity(detailsImportExportDTO.getQuantity());
        detailsImportExport.setTotal(detailsImportExportDTO.getTotal());
        return detailsImportExport;


    }
    public DetailsImportExportDTO toDTO (DetailsImportExport detailsImportExport) {
        DetailsImportExportDTO dto = new DetailsImportExportDTO();
        dto.setIdImportExport(detailsImportExport.getIdImportExport());
        dto.setIdCommodity(detailsImportExport.getIdCommodity());
        dto.setId(detailsImportExport.getId());
        dto.setQuantity(detailsImportExport.getQuantity());
        dto.setDescription(detailsImportExport.getDescription());
        dto.setTotal(detailsImportExport.getTotal());
        dto.setDetailsImportExports(detailsImportExport.getDetailsImportExports().stream()
                .map(commodity -> CommodityMapper.getInstance().toDTO(commodity))
                .collect(Collectors.toList()));
        return dto;

        }
    }*/
@Mapper
public interface DetailsImportExportMapper {
    DetailsImportExportDTO toDetailsImportExportDTO (DetailsImportExport detailsImportExport);
    List<DetailsImportExportDTO> toDetailsImportExportDTOs(List<DetailsImportExport> detailsImportExports);
    DetailsImportExport toDetailsImportExport(DetailsImportExportDTO detailsImportExportDTO);

}




