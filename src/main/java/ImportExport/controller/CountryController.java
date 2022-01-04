package ImportExport.controller;

import ImportExport.dto.country.CountryCreateDto;
import ImportExport.dto.country.CountryDetailDto;
import ImportExport.service.country.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return null;
    }
}

