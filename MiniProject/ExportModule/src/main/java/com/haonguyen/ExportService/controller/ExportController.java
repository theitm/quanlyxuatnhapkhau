package com.haonguyen.ExportService.controller;


import com.haonguyen.ExportService.repository.IDetailsImportExportRepository;
import com.haonguyen.ExportService.service.IDocumentService;
import com.haonguyen.ExportService.service.IImportExportService;
import com.haonguyen.ExportService.service.ImportExportService;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/export")
public class ExportController {

    private final IDocumentService iDocumentService;
    private final IDetailsImportExportRepository iDetailsImportExportRepository;
    private final IImportExportService iImportExportService;

    public ExportController(IDocumentService iDocumentService,
                            IDetailsImportExportRepository iDetailsImportExportRepository,
                            IImportExportService iImportExportService) {
        this.iDocumentService = iDocumentService;
        this.iDetailsImportExportRepository = iDetailsImportExportRepository;
        this.iImportExportService = iImportExportService;
    }

    @RequestMapping(value = "/get-export",method = RequestMethod.GET)
    public List<ImportExportEntity> getExport(){
        return iImportExportService.getExport();
    }
    @RequestMapping(value = "/getexportbycountry/{id}")
    public List<ImportExportEntity> getExportByCountry(@PathVariable("id") UUID id){
        return iImportExportService.getExportByCountryId(id);
    }
    @RequestMapping(value = "/update-export",method = RequestMethod.PUT)
    public ImportExportEntity updateExport(@RequestBody ImportExportEntity importExportEntity){
        return iImportExportService.updateExport(importExportEntity);
    }
}
