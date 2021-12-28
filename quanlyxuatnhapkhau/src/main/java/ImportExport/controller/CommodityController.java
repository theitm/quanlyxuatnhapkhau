package ImportExport.controller;

import ImportExport.entity.CommodityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class CommodityController {
    @Autowired
    private CommodityService service;
    @GetMapping("/commodity")
    public List<CommodityEntity> list() {
        return service.listAll();
    }
    @GetMapping("/commodity/{id}")
    public ResponseEntity<CommodityEntity> get(@PathVariable UUID id) {
        try {
            CommodityEntity commodityEntity = service.get(id);
            return new ResponseEntity<CommodityEntity>(commodityEntity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CommodityEntity>(HttpStatus.NOT_FOUND);
        }
    }
    List<CommodityEntity> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/commodity")
    public ResponseEntity<CommodityEntity> add(@RequestBody CommodityEntity commodityEntity) {
        todoList.add(commodityEntity);
        service.save(commodityEntity);
        return ResponseEntity.ok().body(commodityEntity);
    }
    @PutMapping("/commodity/{id}")
    public ResponseEntity<?> update(@RequestBody CommodityEntity commodityEntity, @PathVariable UUID id) {
        try {
            CommodityEntity existCommodityEntity = service.get(id);
            service.save(commodityEntity);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/commodity/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }


}
