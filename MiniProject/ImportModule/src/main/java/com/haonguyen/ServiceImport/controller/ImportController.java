package com.haonguyen.ServiceImport.controller;

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

import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/import")

public class ImportController {

    @Autowired
    private ImportExportService importExportService;
    @Autowired
    private ReceiptService receiptService;

    public ImportController() {
    }

    @PostMapping("/addReceipt")
    public ResponseEntity addReceipt(@RequestBody ImportReceiptDTO importReceiptDTO) {

        return receiptService.getReceipt(importReceiptDTO);
    }

    @GetMapping("/allReceipt")
    public ResponseEntity getAllReceipt() {
        List<ImportExportEntity> iExportEntityList = importExportService.getAllReceipt();

        return ResponseEntity.ok().body(iExportEntityList);
    }

    @PostMapping("/searchReceipt")
    public List<ImportExportEntity> searchReceipt(@RequestBody KeySearchDTO keySearchDTO) throws ParseException {
        List<ImportExportEntity> iExportEntityList = receiptService.searchReceiptImportExport(keySearchDTO);

        return iExportEntityList;
    }

    @GetMapping("/getReceipt/{idReceipt}")
    public ResponseEntity getReceiptById(@PathVariable(name = "idReceipt") String idReceipt) {

        ImportExportEntity exportEntity = importExportService.getByIdI_Export(UUID.fromString(idReceipt));

        return ResponseEntity.ok().body(exportEntity);
    }

    @GetMapping("/excelReceiptImport/{idReceipt}")
    public ExcelReceiptImportDTO getExcel(@PathVariable(name = "idReceipt") String idReceipt) {
        ImportExportEntity importExportEntity = importExportService.getByIdI_Export(UUID.fromString(idReceipt));

        ExcelReceiptImportMapper excelReceiptImportMapper = new ExcelReceiptImportMapperImpl();

        ExcelReceiptImportDTO excelReceiptImportDTO = excelReceiptImportMapper.toExcelReceiptImportDTO(importExportEntity);

        return excelReceiptImportDTO;

    }

}
