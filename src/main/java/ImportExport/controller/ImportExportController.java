package ImportExport.controller;

import ImportExport.dto.importExport.ImportExportCreateDto;
import ImportExport.dto.importExport.ImportExportDetailDto;
import ImportExport.service.importExport.ImportExportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/api/importExport")

public class ImportExportController {
    private final ImportExportService importExportService;

    public ImportExportController(ImportExportService importExportService) {
        this.importExportService = importExportService;
    }
    @PostMapping
    public ResponseEntity<ImportExportDetailDto> create(@RequestBody ImportExportCreateDto importExportCreateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(importExportService.createImportExport(importExportCreateDto));

    }
    @GetMapping("/{id}")
    public ResponseEntity<ImportExportDetailDto> findById(@PathVariable UUID id) {
        return null;
    }
}