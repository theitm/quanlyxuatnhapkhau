package ImportExport.controller;
import ImportExport.dto.document.DocumentCreateDto;
import ImportExport.dto.document.DocumentDetailDto;
import ImportExport.service.document.DocumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }
}

//    @PutMapping("/document/{id}")
//    public ResponseEntity<?> update(@RequestBody Document document, @PathVariable UUID id) {
//        try {
//            Document existProduct = service.get(id);
//            service.save(document);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    @DeleteMapping("/document/{id}")
//    public void delete(@PathVariable UUID id) {
//        service.delete(id);
//    }
//
//
//
//
//}
