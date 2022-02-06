package ImportExport.service.Receipt;

import ImportExport.dto.importExport.ImportExportAddDto;
import org.springframework.http.ResponseEntity;

public interface ReceiptService {
    ResponseEntity getReceipt(ImportExportAddDto importExportAddDto);
}
