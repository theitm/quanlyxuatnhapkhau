package ImportExport.controller;

import ImportExport.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ImportExport.service.CommodityService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class CommodityController {
    @Autowired
    private CommodityService service;
    @GetMapping("/commodity")
    public List<Commodity> list() {
        return service.listAll();
    }
    @GetMapping("/commodity/{id}")
    public ResponseEntity<Commodity> get(@PathVariable UUID id) {
        try {
            Commodity commodity = service.get(id);
            return new ResponseEntity<Commodity>(commodity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Commodity>(HttpStatus.NOT_FOUND);
        }
    }
    List<Commodity> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/commodity")
    public ResponseEntity<Commodity> add(@RequestBody Commodity commodity) {
        todoList.add(commodity);
        service.save(commodity);
        return ResponseEntity.ok().body(commodity);
    }
    @PutMapping("/commodity/{id}")
    public ResponseEntity<?> update(@RequestBody Commodity commodity, @PathVariable UUID id) {
        try {
            Commodity existCommodity = service.get(id);
            service.save(commodity);
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
