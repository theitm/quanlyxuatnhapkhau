package com.internship.ExportService.controller;


import com.internship.ExportService.DTO.ExportDTO;
import com.internship.ExportService.service.IExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/v1/api/export")
public class ExportController {

    private final IExportService iExportService;
    public ExportController(IExportService iExportService) {
        this.iExportService = iExportService;
    }

    @RequestMapping(value = "/{id}",produces = "application/json;charset=UTF-8",method = RequestMethod.GET)
    public ExportDTO getExport(@PathVariable("id") UUID id){
        return iExportService.getExport(id);
    }
}
