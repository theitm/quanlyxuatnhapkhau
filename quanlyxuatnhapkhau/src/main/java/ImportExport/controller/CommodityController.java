package ImportExport.controller;

import ImportExport.DTO.Commodity.CommodityCreateDto;
import ImportExport.DTO.Commodity.CommodityDTO;
import ImportExport.entity.CommodityEntity;
import ImportExport.service.CommodityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
@RequestMapping
public class CommodityController {
    private final CommodityService commodityService;

    public CommodityController(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @GetMapping("/commodity")
    public List<CommodityDTO> list() {
        return null;
    }

    @GetMapping("/commodity/{id}")
    public ResponseEntity<CommodityDTO> findById(@PathVariable UUID id) {
        return null;
    }

    List<CommodityEntity> todoList = new CopyOnWriteArrayList<>();
    @PostMapping("/commodity")
    public ResponseEntity<CommodityDTO> create(@RequestBody CommodityCreateDto createDto) {
       return ResponseEntity.status(HttpStatus.ACCEPTED).body
                (commodityService.createCommodity(createDto));
    }

    @PutMapping("/commodity/{id}")
    public ResponseEntity<CommodityDTO> update(@RequestBody CommodityEntity commodityEntity,
                                               @PathVariable UUID id) {
       return null;
    }

//    @DeleteMapping("/commodity/{id}")
//    public void delete(@PathVariable UUID id) {
//        commodityService.delete(id);
//    }


}
