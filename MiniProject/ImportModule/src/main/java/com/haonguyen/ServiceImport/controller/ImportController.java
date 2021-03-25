package com.haonguyen.ServiceImport.controller;

import com.haonguyen.ServiceImport.CustomErrorMessage.CommodityException;
import com.haonguyen.ServiceImport.CustomErrorMessage.GlobalRestExceptionHandler;
import com.haonguyen.ServiceImport.CustomErrorMessage.ReceiptImportNotFoundException;
import com.haonguyen.ServiceImport.CustomErrorMessage.SaveException;
import com.haonguyen.ServiceImport.dto.ExcelReceiptImportDTO;
import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.KeySearchDTO;
import com.haonguyen.ServiceImport.mapper.ExcelReceiptImportMapper;
import com.haonguyen.ServiceImport.mapper.ExcelReceiptImportMapperImpl;
import com.haonguyen.ServiceImport.service.ImportExportService;
import com.haonguyen.ServiceImport.service.ReceiptService;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/import")

public class ImportController {

    @Autowired
    private ImportExportService importExportService;
    @Autowired
    private ReceiptService receiptService;
    @Autowired
    private GlobalRestExceptionHandler globalRestExceptionHandler;

    public ImportController() {
    }

    @PostMapping("/addReceipt")
    public ResponseEntity addReceipt(@RequestBody ImportReceiptDTO importReceiptDTO) throws SaveException, CommodityException {

        return receiptService.getReceipt(importReceiptDTO);
    }

    @GetMapping("/allReceipt")
    public List<ImportExportEntity> getAllReceipt() {
        List<ImportExportEntity> iExportEntityList = importExportService.getAllReceipt();

        return iExportEntityList;
    }

    @PostMapping("/searchReceipt")
    public List<ImportExportEntity> searchReceipt(@RequestBody KeySearchDTO keySearchDTO) throws Exception {
        List<ImportExportEntity> iExportEntityList = receiptService.searchReceiptImportExport(keySearchDTO);

        return iExportEntityList;
    }

    @GetMapping("/getReceipt/{idReceipt}")
    public ResponseEntity getReceiptById(@PathVariable(name = "idReceipt") String idReceipt) throws ReceiptImportNotFoundException {

        ImportExportEntity importExportEntity = importExportService.getByIdImportExport(UUID.fromString(idReceipt));
        return ResponseEntity.ok().body(importExportEntity);
    }

    @GetMapping("/excelReceiptImport/{idReceipt}")
    public ExcelReceiptImportDTO getExcel(@PathVariable(name = "idReceipt") String idReceipt) throws ReceiptImportNotFoundException {
        ImportExportEntity importExportEntity = importExportService.getByIdImportExport(UUID.fromString(idReceipt));

        ExcelReceiptImportMapper excelReceiptImportMapper = new ExcelReceiptImportMapperImpl();

        ExcelReceiptImportDTO excelReceiptImportDTO = excelReceiptImportMapper.toExcelReceiptImportDTO(importExportEntity);

        return excelReceiptImportDTO;

    }

}
