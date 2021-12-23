package ImportExport.controller;


import ImportExport.entity.TypeOfCommodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ImportExport.service.TypeOfCommodityServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class TypeOfCommodityController {
    @Autowired
    private TypeOfCommodityServiceImpl service;
    @GetMapping("/type")
    public List<TypeOfCommodity> list() {
        return service.listAll();
    }

    List<TypeOfCommodity> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/type")
    public ResponseEntity<TypeOfCommodity> add(@RequestBody TypeOfCommodity typeOfCommodity) {
        todoList.add(typeOfCommodity);
        service.save(typeOfCommodity);
        return ResponseEntity.ok().body(typeOfCommodity);
    }
    @PutMapping("/type/{id}")
    public ResponseEntity<?> update(@RequestBody TypeOfCommodity typeOfCommodity, @PathVariable UUID id) {
        try {
            TypeOfCommodity existProduct = service.get(id);
            service.save(typeOfCommodity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/type/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }


}