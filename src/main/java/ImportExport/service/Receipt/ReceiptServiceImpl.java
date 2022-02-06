package ImportExport.service.Receipt;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.importExport.ImportExportAddDto;
import ImportExport.entity.*;
import ImportExport.mapper.DetailsImportExportMapper;
import ImportExport.mapper.ImportExportMapper;
import ImportExport.mapper.WarehouseCommodityMapper;
import ImportExport.mapper.WarehouseMapper;
import ImportExport.service.country.CountryService;
import ImportExport.service.detailsImportExport.DetailsImportExportService;
import ImportExport.service.document.DocumentService;
import ImportExport.service.importExport.ImportExportService;
import ImportExport.service.warehouse.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService{
    private final WarehouseService warehouseService;
    private final CountryService countryService;
    private final ImportExportMapper importExportMapper;
    private final DetailsImportExportMapper detailsImportExportMapper;
    private final DocumentService documentService;
    private final DetailsImportExportService detailsImportExportService;
    private final ImportExportService importExportService;
    private final WarehouseCommodityMapper warehouseCommodityMapper;



    public ReceiptServiceImpl(WarehouseService warehouseService, CountryService countryService, ImportExportService importExportService, ImportExportMapper importExportMapper, DetailsImportExportMapper detailsImportExportMapper, DocumentService documentService, DetailsImportExportService detailsImportExportService, ImportExportService importExportService1, WarehouseMapper warehouseMapper, WarehouseCommodityMapper warehouseCommodityMapper) {
        this.warehouseService = warehouseService;
        this.countryService = countryService;
        this.importExportMapper = importExportMapper;
        this.detailsImportExportMapper = detailsImportExportMapper;
        this.documentService = documentService;
        this.detailsImportExportService = detailsImportExportService;
        this.importExportService = importExportService1;
        this.warehouseCommodityMapper = warehouseCommodityMapper;
    }
    public ResponseEntity getReceipt(ImportExportAddDto importExportAddDto) {
        if (importExportAddDto == null) {
            return null;
        }
        List<DetailsImportExportCreateDto> detailsImportExportCreateDtoList = importExportAddDto.getDetailsImportExports();
        CountryEntity countryEntity = importExportService.findCountryById(importExportAddDto.getIdCountry());
        WarehouseEntity warehouseEntity = importExportService.findWarehouseById(importExportAddDto.getIdWarehouse());
        ImportExportEntity importExportEntity = importExportMapper.fromAddDtoToEntity(importExportAddDto);
        List<DocumentEntity> documentEntityList = detailsImportExportMapper.fromListDtoToDocumentEntity(importExportAddDto.getDetailsImportExports());
        List<DetailsImportExportEntity> detailsImportExportEntityList = detailsImportExportMapper.fromListDtoToEntity(importExportAddDto.getDetailsImportExports());
        List<CommodityEntity> commodityEntityList = new ArrayList<>();
        int Max = 0;
        for (DetailsImportExportCreateDto list : detailsImportExportCreateDtoList) {
            Max += list.getQuantity();
        }
        if ( Max < warehouseEntity.getCapacity()) {
            detailsImportExportService.setInfoDetailsImportExport(importExportEntity,detailsImportExportEntityList,commodityEntityList);
            importExportService.setInfoImportExport(countryEntity,warehouseEntity,importExportEntity,documentEntityList,detailsImportExportEntityList);
            ImportExportEntity importExportEntityNew = importExportService.saveImportExportEntity(importExportEntity,importExportAddDto);
            detailsImportExportService.save(detailsImportExportEntityList,importExportEntityNew);
            documentService.save(documentEntityList, importExportEntityNew);
        } else {
            List<WarehouseEntity> recommendWarehouse = importExportService.getWarehouseEntityList(Max);
            return ResponseEntity.ok().body(recommendWarehouse);
        }
        return null;
    }

}
