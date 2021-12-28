package ImportExport.controller;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import ImportExport.entity.DocumentEntity;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import ImportExport.service.DocumentServiceImpl;
@RestController
public class DocumentController {
    @Autowired
    private DocumentServiceImpl service;
    @GetMapping("/document")
    public List<DocumentEntity> list() {
        return service.listAll();
    }

    List<DocumentEntity> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/document")
    public ResponseEntity<DocumentEntity> add(@RequestBody DocumentEntity documentEntity) {
        todoList.add(documentEntity);
        service.save(documentEntity);
        return ResponseEntity.ok().body(documentEntity);
    }
    @PutMapping("/document/{id}")
    public ResponseEntity<?> update(@RequestBody DocumentEntity documentEntity, @PathVariable UUID id) {
        try {
            DocumentEntity existProduct = service.get(id);
            service.save(documentEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/document/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }




}
