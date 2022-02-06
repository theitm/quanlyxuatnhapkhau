package ImportExport.service.detailsImportExport;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;
import ImportExport.dto.importExport.ImportExportAddDto;
import ImportExport.entity.CommodityEntity;
import ImportExport.entity.DetailsImportExportEntity;
import ImportExport.entity.ImportExportEntity;

import java.util.List;
import java.util.UUID;


public interface DetailsImportExportService {
    DetailsImportExportDto createDetailsImportExport(DetailsImportExportCreateDto detailsImportExportCreateDto);
    DetailsImportExportDto findById(UUID id);
    DetailsImportExportDto updateDetailsImportExport(UUID id, DetailsImportExportCreateDto detailsImportExportCreateDto);
    List<DetailsImportExportDto> findAll();
    void deleteById(UUID id);
     void setInfoDetailsImportExport(ImportExportEntity importExportEntity, List<DetailsImportExportEntity> detailsImportExportEntityList, List<CommodityEntity> commodityEntityList);
    DetailsImportExportEntity save(List<DetailsImportExportEntity> detailsImportExportEntityList,ImportExportEntity importExportEntity) ;


    }
