package ImportExport.controller;

import ImportExport.entity.CountryEntity;
import ImportExport.service.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class CountryController {
    @Autowired
    private CountryServiceImpl service;

    public CountryController(CountryServiceImpl service) {
        this.service = service;
    }
    @GetMapping("/country")
    public List<CountryEntity> list() {
        return service.list();
    }
    @GetMapping("/country/{id}")
    public ResponseEntity<CountryEntity> get(@PathVariable UUID id) {
        try {
            CountryEntity countryEntity = service.get(id);
            return new ResponseEntity<CountryEntity>(countryEntity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<CountryEntity>(HttpStatus.NOT_FOUND);
        }
    }
    List<CountryEntity> todoList = new CopyOnWriteArrayList<>();
    @PostMapping("/country")
    public ResponseEntity add(@RequestBody CountryEntity countryEntity){
        todoList.add(countryEntity);
        service.save(countryEntity);
        return ResponseEntity.ok().body(countryEntity);
    }
    @PutMapping("/country/{id}")
    public ResponseEntity<?> update(@RequestBody CountryEntity countryEntity, @PathVariable UUID id){
        try{
            //WareHouseCommodityEntity existWareHouseCommodityEntity = service.get(id);
            service.save(countryEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/country/{id}")
    public void delete(@PathVariable UUID id ){service.delete(id);}
}
