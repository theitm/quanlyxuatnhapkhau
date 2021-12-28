package ImportExport.controller;
/*
import ImportExport.entity.DetailsImportExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ImportExport.service.DetailsImportExportServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;


@RestController
public class DetailsImportExportController {
    @Autowired
    private DetailsImportExportServiceImpl service;
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

 */

import ImportExport.dto.DetailsImportExportDTO;
import ImportExport.entity.DetailsImportExport;
import ImportExport.mapper.DetailsImportExportMapper;
import ImportExport.service.DetailsImportExportServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping
public class DetailsImportExportController {
    private final DetailsImportExportServiceImpl detailsImportExportService;
    private final DetailsImportExportMapper detailsImportExportMapper;
    @GetMapping
    public ResponseEntity<List<DetailsImportExportDTO>> findAll() {
        return ResponseEntity.ok(detailsImportExportMapper.toDetailsImportExportDTOs(detailsImportExportService.findAll()));

    }
    @PostMapping
    public ResponseEntity<DetailsImportExportDTO> create(@RequestBody DetailsImportExportDTO detailsImportExportDTO) {
        detailsImportExportService.save(detailsImportExportMapper.toDetailsImportExport(detailsImportExportDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(detailsImportExportDTO);

    }
    @GetMapping
    public ResponseEntity<DetailsImportExportDTO> create(@PathVariable UUID id) {
        Optional<DetailsImportExport> detailsImportExport = detailsImportExportService.findById(id);
        return ResponseEntity.ok(detailsImportExportMapper.toDetailsImportExportDTO(detailsImportExport.get()));
    }
    @PutMapping
    public ResponseEntity<DetailsImportExportDTO> update(@PathVariable UUID id,@RequestBody DetailsImportExportDTO detailsImportExportDTO) {
        DetailsImportExport detailsImportExport = detailsImportExportMapper.toDetailsImportExport(detailsImportExportDTO);
        detailsImportExport.setId(id);
        detailsImportExportService.save(detailsImportExport);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(detailsImportExportDTO);

    }
    @DeleteMapping
    public ResponseEntity delete(@PathVariable UUID id) {
        detailsImportExportService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
