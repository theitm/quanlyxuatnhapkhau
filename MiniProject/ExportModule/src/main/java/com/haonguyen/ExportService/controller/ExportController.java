package com.haonguyen.ExportService.controller;


import com.haonguyen.ExportService.dto.*;
import com.haonguyen.ExportService.dto.excel.ExcelDocumentDTO;
import com.haonguyen.ExportService.dto.excel.ReturnInfoExportAPI;
import com.haonguyen.ExportService.service.IDetailsImportExportService;
import com.haonguyen.ExportService.service.IDocumentService;
import com.haonguyen.ExportService.service.IImportExportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/api/export")
public class ExportController {

    private final IDocumentService iDocumentService;
    private final IImportExportService iImportExportService;
    private final IDetailsImportExportService iDetailsImportExportService;

    public ExportController(IDocumentService iDocumentService, IImportExportService iImportExportService, IDetailsImportExportService iDetailsImportExportService) {
        this.iDocumentService = iDocumentService;
        this.iImportExportService = iImportExportService;
        this.iDetailsImportExportService = iDetailsImportExportService;
    }

    /**
     * Tìm kiếm một phiếu nhập theo ID
     * @param idExport
     * @return Trả về thông tin phiếu nhập hàng
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ExportFindByIdDTO findByIdExport(@PathVariable("id") UUID idExport) {
        return iImportExportService.findByIdExport(idExport);
    }

    /**
     * Tìm kiếm tất cả hồ sơ liên quan theo Id của phiếu nhâp
     * @param idExport
     * @return danh sách hồ sơ liên quan
     */
    @RequestMapping(value = "/getDocument/{id}")
    public ExcelDocumentDTO findDocumentByIdExport(@PathVariable("id") UUID idExport) {
        return iDocumentService.findDocumentByIdExport(idExport);
    }

    /**
     * Thêm một phiếu xuất hàng vào cơ sở dữ liệu để quản lý
     * @param insertDataExportDTO
     * @return thông tin vừa nhập hàng + chi phí vận chuyển + tổng tiền hóa đơn
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ShowAddExportDTO infoExport(@RequestBody InsertDataExportDTO insertDataExportDTO) {
        return iImportExportService.infoExport(insertDataExportDTO);
    }

    /**
     * Kiểm tra xem hàng hóa có tồn tại trong bất kỳ phiếu nhập nào hat ko
     *
     * @param idCommodity
     * @return True = Không có or False = nếu có
     */
    @RequestMapping(value = "/checkIdCommodity/{id}", method = RequestMethod.GET)
    public String checkIdCommodity(@PathVariable("id") UUID idCommodity) {
        return iDetailsImportExportService.checkIdCommodity(idCommodity).toString();
    }

    /**
     * Lấy thông tin tất cả phiếu nhập theo tháng và năm
     * @param monthAndYear
     * @return Thông tin được truy vấn
     */
    @RequestMapping(value = "/getExcel/{monthAndYear}", method = RequestMethod.GET)
    public List<ReturnInfoExportAPI> getExcel(@PathVariable("monthAndYear") String monthAndYear) {
        return iImportExportService.getExcel(monthAndYear);
    }

    /**
     * Tìm kiếm những hàng xuất được lấy từ nguồn hàng nào ( phiếu nhập thông tin)
     * @param idExport
     * @return danh sách
     */
    @RequestMapping(value = "/sourceExport/{id}", method = RequestMethod.GET)
    public List<SourceExportDTO> sourceExport(@PathVariable("id") UUID idExport) {
        return iDetailsImportExportService.sourceExport(idExport);
    }


}
