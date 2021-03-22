package com.haonguyen.ExportService.controller;


import com.haonguyen.ExportService.dto.*;
import com.haonguyen.ExportService.service.IDocumentService;
import com.haonguyen.ExportService.service.IImportExportService;
import com.mini_project.CoreModule.entity.ImportExportEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/export")
public class ExportController {

    private final IDocumentService iDocumentService;
    private final IImportExportService iImportExportService;

    public ExportController(IDocumentService iDocumentService,
                            IImportExportService iImportExportService) {
        this.iDocumentService = iDocumentService;
        this.iImportExportService = iImportExportService;
    }
    @RequestMapping(value = "/get-export",method = RequestMethod.GET)
    public List<ImportExportEntity> getExport(){
        return iImportExportService.getExport();
    }
    @RequestMapping(value = "/get-export-by-country/{id}")
    public List<ImportExportEntity> getExportByCountry(@PathVariable("id") UUID id){
        return iImportExportService
                .getExportByCountryId(id);
    }
    @RequestMapping(value = "/update-export",method = RequestMethod.PUT)
    public ImportExportEntity updateExport(@RequestBody ImportExportEntity importExportEntity){
        return iImportExportService
                .updateExport(importExportEntity);
    }
    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public ExportFindByIdDTO findByIdExport(@PathVariable("id") UUID idExport){
        return iImportExportService.findByIdExport(idExport);
    }
    @RequestMapping(value = "/list-export-excel/",method = RequestMethod.GET)
    public List<ExcelExportDTO> findByIdExportExcel(){
        return iImportExportService.findAllExport();
    }
    @RequestMapping(value = "/get-document/{id}")
    public ExcelDocumentDTO findDocumentByIdExport(@PathVariable("id") UUID idExport){
        return iDocumentService.findDocumentByIdExport(idExport);
    }
    @RequestMapping(value = "/get-all-document/{id}")
    public List<ExcelDocumentDTO> findAllDocumentByIdExport(@PathVariable("id") UUID idExport){
        return iDocumentService.findAllDocumentByIdExport(idExport);
    }

    /**
     * Thêm một phiếu xuất hàng vào cơ sở dữ liệu để quản lý
     * @param formInsertDataExport
     * @return thông tin vừa nhập hàng + chi phí vận chuyển + tổng tiền hóa đơn
     */
    @RequestMapping(value = "/add-info-export", method = RequestMethod.POST)
    public ShowAddExportDTO addInfoExport(@RequestBody FormInsertDataExport formInsertDataExport){
        return iImportExportService.addInfoExport(formInsertDataExport);
    }
}
