package ImportExport.controller;

import ImportExport.dto.embargo.EmbargoCreateDto;
import ImportExport.dto.embargo.EmbargoDetailDto;
import ImportExport.service.embargo.EmbargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/embargo")
public class EmbargoController {
    private final EmbargoService embargoService;

    public EmbargoController(EmbargoService embargoService) {
        this.embargoService = embargoService;
    }
    @PostMapping
    public ResponseEntity<EmbargoDetailDto> create(@RequestBody EmbargoCreateDto embargoCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(embargoService.createEmbargo(embargoCreateDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmbargoDetailDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(embargoService.findById(id));
    }
    @GetMapping
    public List<EmbargoDetailDto> findAll() {
        return embargoService.findAll();
    }
    @PutMapping
    public ResponseEntity<EmbargoDetailDto> update(@PathVariable UUID id,
                                                   @RequestBody EmbargoCreateDto embargoCreateDto) {
        EmbargoDetailDto embargoDetailDto = embargoService.updateEmbargo(id, embargoCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(embargoDetailDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        embargoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
