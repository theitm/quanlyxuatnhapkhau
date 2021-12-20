package ImportExport.controller;

import ImportExport.entity.TaxBracketEntity;
import ImportExport.service.TaxBracketService;
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
public class TaxBracketController {
    @Autowired
    private TaxBracketService service;

    public TaxBracketController(TaxBracketService service) {
        this.service = service;
    }
    public TaxBracketService getService(){return service;}
    @GetMapping("/TaxBracket")
    public List<TaxBracketEntity> list(){return service.list();}
    @GetMapping("/TaxBracket/{id}")
    public ResponseEntity<TaxBracketEntity> get(@PathVariable UUID id){
        try {
            TaxBracketEntity taxBracketEntity = service.get(id);
            return new ResponseEntity<TaxBracketEntity>(taxBracketEntity, HttpStatus.OK);
        }catch (NoSuchElementException e) {
            return new ResponseEntity<TaxBracketEntity>(HttpStatus.NOT_FOUND);
        }
    }
    List<TaxBracketEntity> todoList = new CopyOnWriteArrayList<>();
    @PostMapping("/TaxBracket")
    public ResponseEntity add(@RequestBody TaxBracketEntity taxBracketEntity){
        todoList.add(taxBracketEntity);
        service.save(taxBracketEntity);
        return ResponseEntity.ok().body(taxBracketEntity);
    }
    @PutMapping("/TaxBracket/{id}")
    public ResponseEntity<?> update(@RequestBody TaxBracketEntity taxBracketEntity,@PathVariable UUID id){
        try {
            service.save(taxBracketEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/TaxBracket/{id}")
    public void delete(@PathVariable UUID id){service.delete(id);}
}
