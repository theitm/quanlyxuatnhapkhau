package ImportExport.controller;

import ImportExport.entity.DetailsImportExportEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ImportExport.ServiceImpl.DetailsImportExportServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class DetailsImportExportController {
    @Autowired
    private DetailsImportExportServiceImpl service;
    @GetMapping("/details")
    public List<DetailsImportExportEntity> list() {
        return service.list();
    }

    List<DetailsImportExportEntity> todoList = new CopyOnWriteArrayList<>();

    @PostMapping("/details")
    public ResponseEntity<DetailsImportExportEntity> add(@RequestBody DetailsImportExportEntity detailsImportExportEntity) {
        todoList.add(detailsImportExportEntity);
        service.save(detailsImportExportEntity);
        return ResponseEntity.ok().body(detailsImportExportEntity);
    }
    @PutMapping("/details/{id}")
    public ResponseEntity<?> update(@RequestBody DetailsImportExportEntity detailsImportExportEntity, @PathVariable UUID id) {
        try {
            DetailsImportExportEntity existDetailsImportExportEntity = service.get(id);
            service.save(existDetailsImportExportEntity);
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
