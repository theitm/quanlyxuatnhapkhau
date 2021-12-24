package ImportExport.controller;

import ImportExport.entity.WareHouseEntity;
import ImportExport.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping
public class WareHouseController {
    @Autowired
    private WareHouseService service;

    public WareHouseService getService() {
        return service;
    }
    public WareHouseController(WareHouseService service){this.service = service;}
    @GetMapping("/warehouses")
    public List<WareHouseEntity> list(){
        return service.list();
    }
    @GetMapping("/warehouses/{id}")
    public ResponseEntity<WareHouseEntity> get(@PathVariable UUID id) {
        try {
            WareHouseEntity wareHouseEntity =service.get(id);
            return new ResponseEntity<WareHouseEntity>(wareHouseEntity, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<WareHouseEntity>(HttpStatus.NOT_FOUND);
        }
    }
    List<WareHouseEntity> todoList = new CopyOnWriteArrayList<>();
        @PostMapping("/warehouses")
    public ResponseEntity add(@RequestBody WareHouseEntity wareHouseEntity) {
        todoList.add(wareHouseEntity);
        service.save(wareHouseEntity);
        return ResponseEntity.ok().body(wareHouseEntity);
    }
    @PutMapping("/warehouses/{id}")
    public ResponseEntity<?> update(@RequestBody WareHouseEntity wareHouseEntity, @PathVariable UUID id){
        try{
            service.save(wareHouseEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/warehouses/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
