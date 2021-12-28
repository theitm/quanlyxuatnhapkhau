package ImportExport.controller;

import ImportExport.entity.EmbargoEntity;
import ImportExport.service.EmbargoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class EmbargoController {
    @Autowired
    private EmbargoServiceImpl service;

    public EmbargoController(EmbargoServiceImpl service) {
        this.service = service;
    }
    @GetMapping("/embargo")
    public List<EmbargoEntity> list() {
        return service.list();
    }
    @GetMapping("/embargo/{id}")
    public ResponseEntity<EmbargoEntity> get(@PathVariable UUID id) {
        try {
            EmbargoEntity embargoEntity = service.get(id);
            return new ResponseEntity<EmbargoEntity>(embargoEntity, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<EmbargoEntity>(HttpStatus.NOT_FOUND);
        }
    }
    List<EmbargoEntity> todoList = new CopyOnWriteArrayList<>();
    @PostMapping("/embargo")
    public ResponseEntity add(@RequestBody EmbargoEntity embargoEntity) {
        todoList.add(embargoEntity);
        service.save(embargoEntity);
        return ResponseEntity.ok().body(embargoEntity);
    }
    @PutMapping("/embargo/{id}")
    public ResponseEntity<?> update(@RequestBody EmbargoEntity embargoEntity, @PathVariable UUID id) {
        try {
            //EmbargoEntity existEmbargo = service.get(id);
            service.save(embargoEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/embargo/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
