package com.haonguyen.ExportService.service;


import com.haonguyen.ExportService.dto.*;
import com.haonguyen.ExportService.mapper.IImportExportMapper;
import com.haonguyen.ExportService.repository.IImportExportRepository;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import java.util.List;
import java.util.UUID;

@Service
public class ImportExportService implements IImportExportService {

    private final IImportExportRepository iImportExportRepository;
    private final IImportExportMapper iImportExportMapper;
    private final IDocumentService iDocumentService;
    private final RestTemplate restTemplate;
    private final IDetailsImportExportService iDetailsImportExportService;

    public ImportExportService(IImportExportRepository iImportExportRepository, IImportExportMapper iImportExportMapper, IDocumentService iDocumentService, RestTemplate restTemplate, IDetailsImportExportService iDetailsImportExportService) {
        this.iImportExportRepository = iImportExportRepository;
        this.iImportExportMapper = iImportExportMapper;
        this.iDocumentService = iDocumentService;
        this.restTemplate = restTemplate;
        this.iDetailsImportExportService = iDetailsImportExportService;
    }

    @Override
    public List<ImportExportEntity> getExport() {
        return iImportExportRepository.findAll();
    }

    @Override
    public List<ImportExportEntity> getExportByCountryId(UUID countryId) {
        return iImportExportRepository.getExportByCountry(countryId);
    }

    @Override
    public ImportExportEntity updateExport(ImportExportEntity importExportEntity) {
        return iImportExportRepository.save(importExportEntity);
    }

    @Override
    public ExportFindByIdDTO findByIdExport(UUID idExport) {
        return iImportExportMapper.toExportFindByIdDTO(iImportExportRepository.getById(idExport));
    }

    @Override
    public ImportExportEntity findByIdExportExcel(UUID idExport) {
        return iImportExportRepository.getById(idExport);
    }

    @Override
    public List<ExcelExportDTO> findAllExport() {
        return iImportExportMapper.toExcelExportDTOs(iImportExportRepository.findAll());
    }

    /**
     * Save vào bảng ImportExportEntity
     * @param importExportEntity
     * @return ExportDTO chứa dữ liệu map từ ImportExportEntity
     */
    public ExportDTO addExport(ImportExportEntity importExportEntity){
        return iImportExportMapper.toExportDTO(iImportExportRepository.save(importExportEntity));
    }

    /**
     * Lấy thông tin liên quan đến hàng hóa thông qua API gọi đến service CommodityModule
     * @param idCommodity
     * @return
     */
    public ApiAllCommodityInfo getApiAllCommodityInfo(UUID idCommodity){
       return restTemplate
               .getForObject("http://localhost:9001/commodity/get-type-tax/" + idCommodity
               ,ApiAllCommodityInfo.class);
    }

    /**
     * Tách dữ liệu từ form nhập người dùng tính toán và đẩy vào csdl
     * @param formInsertDataExport
     * @return return lại all thông tin ra postman
     */
    @Override
    public ShowAddExportDTO infoExport(FormInsertDataExport formInsertDataExport) {

        ExportDTO exportDTO = addExport(ImportExportEntity
                .builder()
                .idCountry(formInsertDataExport.getCountryId())
                .idWarehouse(formInsertDataExport.getWarehouseId())
                .date(formInsertDataExport.getDate())
                .type(1)
                .build());

        formInsertDataExport.setId(exportDTO.getId());

        List<DocumentDTO> documentDTOList
                = iDocumentService.infoDocument(formInsertDataExport);

        List<DetailsExportDTO> detailsExportDTOList
                = iDetailsImportExportService.infoDetailsExport(formInsertDataExport);

        return null;
    }


}
