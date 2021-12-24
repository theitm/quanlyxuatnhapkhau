package ImportExport.controller;

import ImportExport.entity.ImportExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ImportExport.service.ImportExportServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class ImportExportController {
    @Autowired
    private ImportExportServiceImpl service;
    @GetMapping("/import_export")
    public List<ImportExport> list() {
        return service.listAll();
    }

    List<ImportExport> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/import_export")
    public ResponseEntity<ImportExport> add(@RequestBody ImportExport importExport) {
        todoList.add(importExport);
        service.save(importExport);
        return ResponseEntity.ok().body(importExport);
    }
    @PutMapping("/import_export/{id}")
    public ResponseEntity<?> update(@RequestBody ImportExport importExport, @PathVariable UUID id) {
        try {
            ImportExport existImportExport = service.get(id);
            service.save(importExport);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/import_export/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}
