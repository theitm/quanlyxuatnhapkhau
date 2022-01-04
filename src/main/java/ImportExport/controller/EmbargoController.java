package ImportExport.controller;

import ImportExport.dto.embargo.EmbargoCreateDto;
import ImportExport.dto.embargo.EmbargoDetailDto;
import ImportExport.service.embargo.EmbargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }

}
