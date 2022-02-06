package ImportExport.service.importExport;

import ImportExport.dto.importExport.*;
import ImportExport.entity.*;

import java.util.List;
import java.util.UUID;

public interface ImportExportService {

    ImportExportDetailDto findById(UUID id);
    List<ImportExportDetailDto> findAll();
    ImportExportDetailDto updateImExPort(UUID id, ImportExportCreateDto importExportCreateDto);
    void deleteById(UUID id);
    ImportExportDetailDto createImportExport(ImportExportCreateDto importExportCreateDto);
    ImportExportDto addIE(ImportExportAddDto importExportAddDto);
    void setInfoImportExport(CountryEntity countryEntity, WarehouseEntity warehouseEntity,
                             ImportExportEntity importExportEntity,
                             List<DocumentEntity> documentEntityList,
                             List<DetailsImportExportEntity> detailsImportExportEntityList);
    CountryEntity findCountryById(UUID id);
    WarehouseEntity findWarehouseById(UUID id);
    ImportExportEntity saveImportExportEntity(ImportExportEntity importExportEntity,ImportExportAddDto importExportAddDto) ;
    List<WarehouseEntity> getWarehouseEntityList (int Max);


    }