package com.haonguyen.ServiceImport.controller;

import com.haonguyen.ServiceImport.dto.ImportReceiptDTO;
import com.haonguyen.ServiceImport.service.IexportService;
import com.haonguyen.ServiceImport.service.ReceiptService;
import com.mini_project.Coremodule.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
        return
                ResponseEntity.ok().body("success");
    }

    @GetMapping("/allReceipt")
    public ResponseEntity getAllReceipt() {
        List<Import_ExportEntity> iExportEntityList = iexportService.getAllReceipt();

        return ResponseEntity.ok().body(iExportEntityList);
    }

    @GetMapping("/searchReceipt/{key}")
    public ResponseEntity searchReceipt(@PathVariable(name = "key") String key) {
        List<Import_ExportEntity> iExportEntityList = iexportService.searchI_export(key);


        return ResponseEntity.ok().body(iExportEntityList);
    }

    @GetMapping("/getReceipt/{idReceipt}")
    public ResponseEntity getReceiptById(@PathVariable(name = "idReceipt") String idReceipt) {

        List<Import_ExportEntity> exportEntityList = iexportService.getByIdI_Export(UUID.fromString(idReceipt));

        return ResponseEntity.ok().body(exportEntityList);
    }

    @DeleteMapping("/deleteReceipt/{idReceipt}")
    public ResponseEntity deleteReceipt(@PathVariable(name = "idReceipt") String idReceipt) {
        iexportService.deleteById(UUID.fromString(idReceipt));

        return ResponseEntity.ok().body("success");
    }
}
