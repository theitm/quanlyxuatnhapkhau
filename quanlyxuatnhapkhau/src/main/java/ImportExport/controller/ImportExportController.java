package ImportExport.controller;

import ImportExport.entity.ImportExportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ImportExport.ServiceImpl.ImportExportServiceImpl;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class ImportExportController {
    @Autowired
    private ImportExportServiceImpl service;
    @GetMapping("/import_export")
    public List<ImportExportEntity> list() {
        return service.list();
    }

    List<ImportExportEntity> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/import_export")
    public ResponseEntity<ImportExportEntity> add(@RequestBody ImportExportEntity importExportEntity) {
        todoList.add(importExportEntity);
        service.save(importExportEntity);
        return ResponseEntity.ok().body(importExportEntity);
    }
    @PutMapping("/import_export/{id}")
    public ResponseEntity<?> update(@RequestBody ImportExportEntity importExportEntity, @PathVariable UUID id) {
        try {
            ImportExportEntity existImportExportEntity = service.get(id);
            service.save(importExportEntity);
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
