package com.haonguyen.ExportService.dto.excel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelDocumentDTO {

    private String imageUrl;
}
