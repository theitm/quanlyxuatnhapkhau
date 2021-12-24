package ImportExport.controller;

import ImportExport.entity.WareHouseCommodityEntity;
import ImportExport.service.WareHouseCommodityService;
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
public class WareHouseCommodityController {
    @Autowired
    private WareHouseCommodityService service;
    public WareHouseCommodityService getService() {
        return service;
    }
    public WareHouseCommodityController(WareHouseCommodityService service){
        this.service = service;
    }

    @GetMapping("/WH_commodity")
        public List<WareHouseCommodityEntity> list(){
        return  service.list();
    }
    @GetMapping("/WH_commodity/{id}")
    public ResponseEntity<WareHouseCommodityEntity> get(@PathVariable UUID id){
        try {
            WareHouseCommodityEntity wareHouseCommodityEntity = service.get(id);
            return new ResponseEntity<WareHouseCommodityEntity>(wareHouseCommodityEntity, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<WareHouseCommodityEntity>(HttpStatus.NOT_FOUND);
        }
    }
    List<WareHouseCommodityEntity> todoList = new CopyOnWriteArrayList<>();
    @PostMapping("/WH_commodity")
    public ResponseEntity add(@RequestBody WareHouseCommodityEntity wareHouseCommodityEntity){
        todoList.add(wareHouseCommodityEntity);
        service.save(wareHouseCommodityEntity);
        return ResponseEntity.ok().body(wareHouseCommodityEntity);
    }
    @PutMapping("/WH_commodity/{id}")
    public ResponseEntity<?> update(@RequestBody WareHouseCommodityEntity wareHouseCommodityEntity, @PathVariable UUID id){
        try{
            //WareHouseCommodityEntity existWareHouseCommodityEntity = service.get(id);
            service.save(wareHouseCommodityEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/WH_commodity/{id}")
    public void delete(@PathVariable UUID id ){service.delete(id);}

}
