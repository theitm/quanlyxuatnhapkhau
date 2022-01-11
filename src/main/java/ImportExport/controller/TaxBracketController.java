package ImportExport.controller;

import ImportExport.dto.taxBracket.TaxBracketCreateDto;
import ImportExport.dto.taxBracket.TaxBracketDetailDto;
import ImportExport.service.taxBracket.TaxBracketService;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/taxBracket")
public class TaxBracketController {
    private final TaxBracketService taxBracketService;

    public TaxBracketController(TaxBracketService taxBracketService) {
        this.taxBracketService = taxBracketService;
    }
    @PostMapping
    public ResponseEntity<TaxBracketDetailDto> create(@RequestBody TaxBracketCreateDto taxBracketCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taxBracketService.createTaxBracket(taxBracketCreateDto));

    }
    @GetMapping("/{id}")
    public ResponseEntity<TaxBracketDetailDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(taxBracketService.findById(id));
    }
    @GetMapping
    public List<TaxBracketDetailDto> findAll() {
        return taxBracketService.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<TaxBracketDetailDto> update(@PathVariable UUID id,
                                      @RequestBody TaxBracketCreateDto taxBracketCreateDto) {
        TaxBracketDetailDto taxBracketDetailDto = taxBracketService.updateTaxBracket(id, taxBracketCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taxBracketDetailDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id ) {
        taxBracketService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
