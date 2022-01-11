package ImportExport.controller;
import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.document.DocumentDetailDto;
import ImportExport.service.document.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/document")

public class DocumentController {
    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }
    @PostMapping
    public ResponseEntity<DocumentDetailDto> create(@RequestBody DocumentCreateDto documentCreateDto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(documentService.createDocument(documentCreateDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DocumentDetailDto> findById(@PathVariable UUID id){
        return ResponseEntity.ok(documentService.findById(id));
    }
    @GetMapping
    public List<DocumentDetailDto> findAll(){
        return documentService.findAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<DocumentDetailDto> update(@PathVariable UUID id,
                                                    @RequestBody DocumentCreateDto documentCreateDto) {
        DocumentDetailDto documentDetailDto = documentService.updateDocument(id, documentCreateDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(documentDetailDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id){
        documentService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}


