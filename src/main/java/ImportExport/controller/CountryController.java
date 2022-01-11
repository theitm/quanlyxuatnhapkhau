package ImportExport.controller;

import ImportExport.dto.country.CountryCreateDto;
import ImportExport.dto.country.CountryDetailDto;
import ImportExport.entity.CountryEntity;
import ImportExport.service.country.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/country")

public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    public ResponseEntity<CountryDetailDto> create(@RequestBody CountryCreateDto countryCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(countryService.createCountry(countryCreateDto));
    }

    @GetMapping("/{id}")
   public ResponseEntity<CountryDetailDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(countryService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryDetailDto> update(@PathVariable UUID id,
                                                   @RequestBody CountryCreateDto countryCreateDto) {
        CountryDetailDto countryDetailDto = countryService.updateCountry(id, countryCreateDto);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(countryDetailDto);
    }

    @GetMapping
    public  List<CountryDetailDto> findAll() {
        return countryService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        countryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
