package ImportExport.controller;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import ImportExport.entity.Document;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;
import ImportExport.service.DocumentService;
@RestController
public class DocumentController {
    @Autowired
    private DocumentService service;
    @GetMapping("/document")
    public List<Document> list() {
        return service.listAll();
    }

    List<Document> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/document")
    public ResponseEntity<Document> add(@RequestBody Document document) {
        todoList.add(document);
        service.save(document);
        return ResponseEntity.ok().body(document);
    }
    @PutMapping("/document/{id}")
    public ResponseEntity<?> update(@RequestBody Document document, @PathVariable UUID id) {
        try {
            Document existProduct = service.get(id);
            service.save(document);
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
