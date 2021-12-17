package ImportExport.controller;

import ImportExport.entity.DetailsImportExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ImportExport.service.DetailsImportExportService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class DetailsImportExportController {
    @Autowired
    private DetailsImportExportService service;
    @GetMapping("/details")
    public List<DetailsImportExport> list() {
        return service.listAll();
    }

    List<DetailsImportExport> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/details")
    public ResponseEntity<DetailsImportExport> add(@RequestBody DetailsImportExport detailsImportExport) {
        todoList.add(detailsImportExport);
        service.save(detailsImportExport);
        return ResponseEntity.ok().body(detailsImportExport);
    }
    @PutMapping("/details/{id}")
    public ResponseEntity<?> update(@RequestBody DetailsImportExport detailsImportExport, @PathVariable UUID id) {
        try {
            DetailsImportExport existDetailsImportExport = service.get(id);
            service.save(existDetailsImportExport);
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/details/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }


}
