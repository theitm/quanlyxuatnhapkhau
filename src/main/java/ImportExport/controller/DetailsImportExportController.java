package ImportExport.controller;

import ImportExport.dto.detailsImportExport.DetailsImportExportCreateDto;
import ImportExport.dto.detailsImportExport.DetailsImportExportDto;
import ImportExport.service.detailsImportExport.DetailsImportExportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("v1/api/detailsImportExport")

public class DetailsImportExportController {
    private final DetailsImportExportService detailsImportExportService;

    public DetailsImportExportController(DetailsImportExportService detailsImportExportService) {
        this.detailsImportExportService = detailsImportExportService;
    }
    @PostMapping
    public ResponseEntity<DetailsImportExportDto> create(@RequestBody DetailsImportExportCreateDto detailsImportExportCreateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(detailsImportExportService.createDetailsImportExport(detailsImportExportCreateDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DetailsImportExportDto> findById(@PathVariable UUID id) {
        return null;
    }
}
//    @GetMapping
//    public ResponseEntity<DetailsImportExportDTO> create(@PathVariable UUID id) {
//        Optional<detailsImportExport> detailsImportExport = detailsImportExportService.findById(id);
//        return ResponseEntity.ok(detailsImportExportMapper.toDetailsImportExportDTO(detailsImportExport.get()));
//    }
//    @PutMapping
//    public ResponseEntity<DetailsImportExportDTO> update(@PathVariable UUID id,@RequestBody DetailsImportExportDTO detailsImportExportDTO) {
//        detailsImportExport detailsImportExport = detailsImportExportMapper.toDetailsImportExport(detailsImportExportDTO);
//        detailsImportExport.setId(id);
//        detailsImportExportService.save(detailsImportExport);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).body(detailsImportExportDTO);
//
//    }
//    @DeleteMapping
//    public ResponseEntity delete(@PathVariable UUID id) {
//        detailsImportExportService.deleteById(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//    }
//
//
//}
