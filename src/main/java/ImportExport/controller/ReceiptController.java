package ImportExport.controller;

import ImportExport.dto.importExport.ImportExportAddDto;
import ImportExport.service.Receipt.ReceiptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/Receipt")
public class ReceiptController {
    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @PostMapping("/addReceipt")
    public ResponseEntity addReceipt(@RequestBody ImportExportAddDto importExportAddDto)  {

        return receiptService.getReceipt(importExportAddDto);
    }
}
