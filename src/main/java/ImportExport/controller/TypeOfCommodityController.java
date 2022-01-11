package ImportExport.controller;

import ImportExport.dto.typeOfCommodity.TypeOfCommodityCreateDto;
import ImportExport.dto.typeOfCommodity.TypeOfCommodityDetailDto;
import ImportExport.service.typeOfCommodity.TypeOfCommodityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/typeOfCommodity")

public class TypeOfCommodityController {
    private final TypeOfCommodityService typeOfCommodityService;

    public TypeOfCommodityController(TypeOfCommodityService typeOfCommodityService) {
        this.typeOfCommodityService = typeOfCommodityService;
    }
    @PostMapping
    public ResponseEntity<TypeOfCommodityDetailDto> create(@RequestBody TypeOfCommodityCreateDto typeOfCommodityCreateDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(typeOfCommodityService.createTypeOfCommodity(typeOfCommodityCreateDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TypeOfCommodityDetailDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(typeOfCommodityService.findById(id));
    }
    @GetMapping
    public List<TypeOfCommodityDetailDto> findAll() {
        return typeOfCommodityService.findAll();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        typeOfCommodityService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}