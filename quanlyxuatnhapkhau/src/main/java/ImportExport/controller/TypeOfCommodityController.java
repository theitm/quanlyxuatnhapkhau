package ImportExport.controller;


import ImportExport.entity.TypeOfCommodityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ImportExport.ServiceImpl.TypeOfCommodityServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class TypeOfCommodityController {
    @Autowired
    private TypeOfCommodityServiceImpl service;
    @GetMapping("/type")
    public List<TypeOfCommodityEntity> list() {
        return service.list();
    }

    List<TypeOfCommodityEntity> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/type")
    public ResponseEntity<TypeOfCommodityEntity> add(@RequestBody TypeOfCommodityEntity typeOfCommodityEntity) {
        todoList.add(typeOfCommodityEntity);
        service.save(typeOfCommodityEntity);
        return ResponseEntity.ok().body(typeOfCommodityEntity);
    }
    @PutMapping("/type/{id}")
    public ResponseEntity<?> update(@RequestBody TypeOfCommodityEntity typeOfCommodityEntity, @PathVariable UUID id) {
        try {
            TypeOfCommodityEntity existProduct = service.get(id);
            service.save(typeOfCommodityEntity);
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