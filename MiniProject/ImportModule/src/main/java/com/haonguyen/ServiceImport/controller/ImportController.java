package com.haonguyen.ServiceImport.controller;

import com.haonguyen.ServiceImport.dto.ExcelReceiptImportDTO;
import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.dto.KeySearchDTO;
import com.haonguyen.ServiceImport.mapper.ExcelReceiptImportMapper;
import com.haonguyen.ServiceImport.mapper.ExcelReceiptImportMapperImpl;
import com.haonguyen.ServiceImport.service.IexportService;
import com.haonguyen.ServiceImport.service.ReceiptService;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/import")

public class ImportController {

    @Autowired
    private IexportService iexportService;
    @Autowired
    private ReceiptService receiptService;

    public ImportController() {
    }

    @PostMapping("/addReceipt")
    public ResponseEntity addReceipt(@RequestBody ImportReceiptDTO importReceiptDTO) {

        return receiptService.getReceipt(importReceiptDTO);
    }

    @PutMapping("/updateReceipt/{idReceipt}")
    public ResponseEntity updateReceipt() {
        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/allReceipt")
    public ResponseEntity getAllReceipt() {
        List<ImportExportEntity> iExportEntityList = iexportService.getAllReceipt();

        return ResponseEntity.ok().body(iExportEntityList);
    }

    @PostMapping("/searchReceipt")
    public List<ImportExportEntity> searchReceipt(@RequestBody KeySearchDTO keySearchDTO) throws ParseException {
        Date dateSearch = new SimpleDateFormat("yyyy-MM-dd").parse(keySearchDTO.getDate());
        if (keySearchDTO.getKey() == null) {
            List<ImportExportEntity> iExportEntityList = iexportService.findAllByDate(dateSearch);
            return iExportEntityList;
        }

        List<ImportExportEntity> iExportEntityList = iexportService.searchI_export(keySearchDTO.getKey(), dateSearch);


        return iExportEntityList;
    }

    @GetMapping("/getReceipt/{idReceipt}")
    public ResponseEntity getReceiptById(@PathVariable(name = "idReceipt") String idReceipt) {

        ImportExportEntity exportEntity = iexportService.getByIdI_Export(UUID.fromString(idReceipt));

        return ResponseEntity.ok().body(exportEntity);
    }

    @DeleteMapping("/deleteReceipt/{idReceipt}")
    public ResponseEntity deleteReceipt(@PathVariable(name = "idReceipt") String idReceipt) {
        iexportService.deleteById(UUID.fromString(idReceipt));

        return ResponseEntity.ok().body("success");
    }

    @GetMapping("/excelReceiptImport/{idReceipt}")
    public ExcelReceiptImportDTO getExcel(@PathVariable(name = "idReceipt") String idReceipt) {
        ImportExportEntity importExportEntity = iexportService.getByIdI_Export(UUID.fromString(idReceipt));

        ExcelReceiptImportMapper excelReceiptImportMapper = new ExcelReceiptImportMapperImpl();

        ExcelReceiptImportDTO excelReceiptImportDTO = excelReceiptImportMapper.toExcelReceiptImportDTO(importExportEntity);

        return excelReceiptImportDTO;

    }

}
