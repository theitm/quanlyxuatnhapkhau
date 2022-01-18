package ImportExport.controller;

import ImportExport.dto.importExport.ImportExportAddDto;
import ImportExport.dto.importExport.ImportExportDto;
import ImportExport.dto.importExport.ImportExportCreateDto;
import ImportExport.dto.importExport.ImportExportDetailDto;
import ImportExport.service.detailsImportExport.DetailsImportExportService;
import ImportExport.service.importExport.ImportExportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/importExport")

public class ImportExportController {
    private final ImportExportService importExportService;
    private final DetailsImportExportService detailsImportExportService;

    public ImportExportController(ImportExportService importExportService, DetailsImportExportService detailsImportExportService) {
        this.importExportService = importExportService;
        this.detailsImportExportService = detailsImportExportService;
    }
//    @PostMapping
//    public ResponseEntity<ImportExportDetailDto> create(@RequestBody ImportExportCreateDto importExportCreateDto ){
//
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(importExportService.createImportExport(importExportCreateDto));
//
//
//    }
    @PostMapping
    public ResponseEntity<ImportExportDto> addIE(@RequestBody ImportExportAddDto importExportAddDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(importExportService.addIE(importExportAddDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImportExportDetailDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(importExportService.findById(id));
    }
    @GetMapping
    public List<ImportExportDetailDto> findAll() {
        return importExportService.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ImportExportDetailDto> update(@PathVariable UUID id,
                                                        @RequestBody ImportExportCreateDto importExportCreateDto) {
        ImportExportDetailDto importExportDetailDto = importExportService.updateImExPort(id, importExportCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(importExportDetailDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        importExportService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}