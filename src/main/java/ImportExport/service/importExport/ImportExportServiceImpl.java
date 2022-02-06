package ImportExport.service.importExport;

import ImportExport.dto.country.CountryDetailDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.document.DocumentDetailDto;
import ImportExport.dto.importExport.*;
import ImportExport.dto.warehouse.WarehouseDetailDto;
import ImportExport.entity.*;
import ImportExport.mapper.ImportExportMapper;
import ImportExport.repository.ImportExportRepository;
import ImportExport.service.country.CountryService;
import ImportExport.service.detailsImportExport.DetailsImportExportService;
import ImportExport.service.document.DocumentService;
import ImportExport.service.warehouse.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImportExportServiceImpl implements ImportExportService {
    private final ImportExportRepository importExportRepository;
    private final ImportExportMapper importExportMapper;
    private final DetailsImportExportService detailsImportExportService;
    private final DocumentService documentService;
    private final WarehouseService warehouseService;
    private final CountryService countryService;

    public ImportExportServiceImpl(ImportExportRepository importExportRepository, ImportExportMapper importExportMapper, DetailsImportExportService detailsImportExportService, DocumentService documentService, WarehouseService warehouseService, CountryService countryService) {
        this.importExportRepository = importExportRepository;
        this.importExportMapper = importExportMapper;
        this.detailsImportExportService = detailsImportExportService;
        this.documentService = documentService;
        this.warehouseService = warehouseService;
        this.countryService = countryService;
    }

    /**
     * Hiện hàng xuất nhập theo ID
     * @param id
     * @return
     */
    public ImportExportDetailDto findById(UUID id) {
        ImportExportDetailDto importExportDetailDto = importExportMapper.fromEntityToDto(importExportRepository.getById(id));
        return importExportDetailDto;
    }

    /**
     * Hiện danh sách hàng xuất nhập
     * @return
     */
    public List<ImportExportDetailDto> findAll() {
        return importExportMapper.fromListEntityToDto(importExportRepository.findAll());
    }

    /**
     * Tạo một xuất nhập hàng hóa
     * @param importExportCreateDto
     * @return
     */
    public ImportExportDetailDto createImportExport(ImportExportCreateDto importExportCreateDto) {
        ImportExportEntity importExportEntity = importExportMapper.fromImportExportCreateDto(importExportCreateDto);
        ImportExportEntity importExportEntityCreate = importExportRepository.save(importExportEntity);
        ImportExportDetailDto importExportDetailDto = null;
        if(importExportEntityCreate != null) {
            importExportDetailDto = importExportMapper.fromEntityToDto(importExportEntityCreate);
        }
        return importExportDetailDto;
    }

    /**
     * Cập nhật xuất nhập hàng hóa
     * @param id
     * @param importExportCreateDto
     * @return
     */
    public ImportExportDetailDto updateImExPort(UUID id, ImportExportCreateDto importExportCreateDto) {
        ImportExportEntity importExportEntity = importExportMapper.fromImportExportCreateDto(importExportCreateDto);
        importExportEntity.setId(id);
        importExportRepository.save(importExportEntity);
        ImportExportDetailDto importExportDetailDto = importExportMapper.fromEntityToDto(importExportEntity);
        return importExportDetailDto;
    }

    /**
     * Xóa một xuất nhập hàng hóa theo ID
     * @param id
     */
    public void deleteById(UUID id) {
        importExportRepository.deleteById(id);
    }

    /**
     * ImportCommodity
     * @param importExportAddDto
     * @return
     */

    public ImportExportDto addIE(ImportExportAddDto importExportAddDto) {
        ImportExportEntity importExportEntity = importExportMapper.fromAddDtoToEntity(importExportAddDto);
        importExportEntity.setDetailsImportExports(null);
        importExportEntity.setDocuments(null);
        ImportExportEntity importExportCreatedEntity = importExportRepository.save(importExportEntity);
        for (DetailsImportExportCreateDto detailsImportExportCreateDto : importExportAddDto.getDetailsImportExports() ) {
            //detailsImportExportCreateDto.setIdImportExport(importExportCreatedEntity.getId());
             detailsImportExportService.createDetailsImportExport(detailsImportExportCreateDto);

        }
        for (DocumentCreateDto documentCreateDto : importExportAddDto.getDocuments()) {
            //documentCreateDto.setIdImportExport(importExportCreatedEntity.getId());
            documentService.createDocument(documentCreateDto);
        }
//        Double capacity = importExportAddDto.getWarehouse().getCapacity();
//        Double  result = 0.0;
//        Double quantity = importExportAddDto.getDetailsImportExports().get(0).getQuantity();
//        if (importExportAddDto.getType() == 1) {
//             result = capacity - quantity;
//        }
//        if (importExportAddDto.getType()==0) {
//             result = capacity + quantity;
//        }


        return null;

    }
    public void setInfoImportExport(CountryEntity countryEntity, WarehouseEntity warehouseEntity,
                                    ImportExportEntity importExportEntity,
                                    List<DocumentEntity> documentEntityList,
                                    List<DetailsImportExportEntity> detailsImportExportEntityList) {
        importExportEntity.setCountryEntity(countryEntity);
        importExportEntity.setDetailsImportExports(detailsImportExportEntityList);
        importExportEntity.setWarehouse(warehouseEntity);
        importExportEntity.setDocuments(documentEntityList);
    }
    public CountryEntity findCountryById(UUID id) {
        return importExportRepository.findByIdCountry(id);
    }
    public WarehouseEntity findWarehouseById(UUID id) {
        return importExportRepository.findByIdWarehouse(id);
    }
    public List<WarehouseEntity> findAllWarehouse() {
        return importExportRepository.findAllWarehouse();
    }
    public ImportExportEntity saveImportExportEntity(ImportExportEntity importExportEntity,ImportExportAddDto importExportAddDto) {

            ImportExportEntity importExportEntity1 = importExportMapper.fromAddDtoToEntity(importExportAddDto);
            ImportExportEntity importExportEntity2 = importExportRepository.save(importExportEntity1);
            importExportEntity.setId(importExportEntity2.getId());

            return importExportEntity;
    }
    public List<WarehouseEntity> getWarehouseEntityList (int Max) {
        List<WarehouseEntity> warehouseEntityList = findAllWarehouse();
        List<WarehouseEntity> recommendWarehouse  = new ArrayList<>();
        for (WarehouseEntity list : warehouseEntityList){
            if(list.getCapacity() > Max)
                recommendWarehouse.add(list);
        }
        return recommendWarehouse;
    }

}