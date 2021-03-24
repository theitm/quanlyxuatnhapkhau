package com.haonguyen.StatementService.service;


import com.haonguyen.StatementService.dto.ExcelDetailsExportDTO;
import com.haonguyen.StatementService.dto.ExcelDocumentDTO;
import com.haonguyen.StatementService.dto.InfoExportAPI;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Style;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ExportExcelService implements IExportExcelService{

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private String nameSheetList = "Export";
    private final IStatementService iStatementService;
    public ExportExcelService(IStatementService iStatementService) {
        workbook = new XSSFWorkbook();
        this.iStatementService = iStatementService;
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue(value.toString());
        }
        cell.setCellStyle(style);
    }
    private void createCellAndHyperLink(Row row, int columnCount, Object value,
                                        CellStyle style , String nameSheet) {

        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else {
            cell.setCellValue(value.toString());
        }

        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet2 = workbook.createSheet(nameSheet);
        Hyperlink link = creationHelper.createHyperlink(HyperlinkType.DOCUMENT);
        link.setAddress("'"+nameSheet+"'!B1");
        cell.setHyperlink(link);
        cell.setCellStyle(style);
    }

    private CellStyle styleForHeader(){
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();

        font.setBold(true);
        font.setFontHeight(18);
        font.setFontName("Times New Roman");
        font.setColor(Font.COLOR_RED);

        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        //style.setFillBackgroundColor();
        return style;
    }
    //Tạo dòng tiêu đề
    private void writeHeaderLineForListExport(int month, int year) {

        sheet = workbook.createSheet(nameSheetList);
        CellStyle style = styleForHeader();

        Row rowHeader = sheet.createRow(0);
        sheet.addMergedRegion(CellRangeAddress.valueOf("B1:J1"));
        createCell(rowHeader,1,"Danh sách phiếu nhập hàng tháng "+month+" năm "+year,style);
        sheet.autoSizeColumn(1);

        //Font and create cell

        Row row = sheet.createRow(1);
        //font.setFontHeight(14);
        //style.setFont(font);

        createCell(row,0,"STT", style);
        createCell(row,1,"Export ID", style);
        createCell(row,2,"Warehouse ID", style);
        createCell(row,3,"Country ID", style);
        createCell(row,4,"Warehouse Name", style);
        createCell(row,5,"Country Name", style);
        createCell(row,6,"Date",style);
        createCell(row,7,"Transportation Coasts", style);
        createCell(row,8,"Sub Total", style);
        createCell(row,9,"List Details Commodity Export", style);
        createCell(row,10,"List Document", style);
    }
    private void writeHeaderLineSheetCommodity(String nameSheetCommodity) {

        sheet = workbook.getSheet(nameSheetCommodity);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();

        font.setBold(true);
        font.setFontHeight(14);
        font.setColor(Font.COLOR_RED);

        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);

        Row rowHeader = sheet.createRow(0);
        //------------------
        createCell(rowHeader,0,"<<Back<<",style);
        Cell cell = rowHeader.getCell(0);
        CreationHelper creationHelper = workbook.getCreationHelper();
        Hyperlink link = creationHelper.createHyperlink(HyperlinkType.DOCUMENT);
        link.setAddress("'"+nameSheetList+"'!A2");
        cell.setHyperlink(link);
        //--------------------
        sheet.addMergedRegion(CellRangeAddress.valueOf("B1:H1"));
        createCell(rowHeader,1,"Danh sách chi tiết hàng hóa trong phiếu nhập",style);
        sheet.autoSizeColumn(1);

        Row row = sheet.createRow(1);
        createCell(row,0,"STT", style);
        createCell(row,1,"Commodity ID", style);
        createCell(row,2,"Commodity Name", style);
        createCell(row,3,"Commodity Type",style);
        createCell(row,4,"Quantity", style);
        createCell(row,5,"Price", style);
        createCell(row,6,"Total", style);

    }

    private void writeHeaderLineSheetDocument(String nameSheetDocument) {

        sheet = workbook.getSheet(nameSheetDocument);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();

        font.setBold(true);
        font.setFontHeight(14);
        font.setColor(Font.COLOR_RED);

        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);


        Row rowHeader = sheet.createRow(0);
        //------------------
        createCell(rowHeader,0,"<<Back<<",style);
        Cell cell = rowHeader.getCell(0);
        CreationHelper creationHelper = workbook.getCreationHelper();
        Hyperlink link = creationHelper.createHyperlink(HyperlinkType.DOCUMENT);
        link.setAddress("'"+nameSheetList+"'!A2");
        cell.setHyperlink(link);
        //--------------------

        sheet.addMergedRegion(CellRangeAddress.valueOf("B1:D1"));
        createCell(rowHeader,1,"Danh sách hồ sơ liên quan nhập hàng",style);
        sheet.autoSizeColumn(1);

        Row row = sheet.createRow(1);
        createCell(row,0,"STT", style);
        createCell(row,1,"URL", style);

    }

    //Ghi du lieu cho sheet Danh sach
    private void writeDataLinesForListExport(String monthAndYear) {

        InfoExportAPI[] infoExportAPIS = iStatementService.getInfoExportAPI(monthAndYear);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();

        font.setFontHeight(14);
        style.setFont(font);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        int numericalOrder = 1 , rowCount = 2 , columnCount = 0;
        for (InfoExportAPI details : infoExportAPIS) {

            sheet = workbook.getSheet(nameSheetList);
            Row row = sheet.createRow(rowCount++);
            columnCount = 0;

            //create cell data list export
            createCell(row, columnCount++, numericalOrder++, style);
            createCell(row, columnCount++, details.getExcelExportDTO().getId().toString(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getIdWarehouse(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getIdCountry(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getWarehouseName(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getCountryName(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getDate(), style);
            createCell(row, columnCount++,"Test Transportation" ,style);
            createCell(row, columnCount++,"Test Total",style);

            //Create Cell And HyperLink Details Export
            String nameSheetCommodity = "Commodity row " + rowCount;
            createCellAndHyperLink(row, columnCount++,"Details Commodity" ,style,nameSheetCommodity);
            writeHeaderLineSheetCommodity(nameSheetCommodity);
            writeDataLinesForCommodity(details.getExcelDetailsExportDTOS(),nameSheetCommodity);

            //Create Cell And HyperLink Document
            String nameSheetDocument = "Document row " + rowCount;
            createCellAndHyperLink(row, columnCount++,"URL Image",style,nameSheetDocument);
            writeHeaderLineSheetDocument(nameSheetDocument);
            writeDataLinesForDocument(details.getExcelDocumentDTOS(),nameSheetDocument);

        }
    }

    //Ghi du liệu cho từng sheet tài liệu liên quan trong phiếu nhập
    private void writeDataLinesForDocument(List<ExcelDocumentDTO> documentDTOList
            , String nameSheetDocument) {
        sheet = workbook.getSheet(nameSheetDocument);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();

        font.setFontHeight(14);
        style.setFont(font);

        int numericalOrder = 1 ,rowCount = 2 , columnCount = 0;
        for (ExcelDocumentDTO temp : documentDTOList) {
            Row row = sheet.createRow(rowCount++);
            columnCount = 0;
            //create cell data details export commodity
            createCell(row, columnCount++, numericalOrder++, style);
            createCell(row, columnCount++,temp.getImageUrl(), style);
        }
    }

    //Ghi du liệu cho từng sheet chi tiết hàng hóa nhập trong phiếu nhập
    private void writeDataLinesForCommodity(List<ExcelDetailsExportDTO> excelDetailsExportDTOS
            ,String nameSheetCommodity) {
        sheet = workbook.getSheet(nameSheetCommodity);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();

        font.setFontHeight(14);
        style.setFont(font);

        int numericalOrder = 1 , rowCount = 2 , columnCount = 0;

        for (ExcelDetailsExportDTO temp : excelDetailsExportDTOS) {
            Row row = sheet.createRow(rowCount++);
            columnCount = 0;
            //create cell data details export commodity
            createCell(row, columnCount++, numericalOrder++, style);
            createCell(row, columnCount++,temp.getIdCommodity() , style);
            createCell(row, columnCount++,temp.getCommodityName(), style);
            createCell(row, columnCount++,temp.getTypeOfCommodityName(), style);
            createCell(row, columnCount++,temp.getQuantity() , style);
            createCell(row, columnCount++,temp.getPrice(), style);
            createCell(row, columnCount++,temp.getTotal(), style);

        }
    }

    @Override
    public void export(HttpServletResponse response, String monthAndYear) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss_dd-MM-yyyy");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ExportCommodity_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        String[] temp = monthAndYear.split("&");
        int month = Integer.parseInt(temp[0]);
        int year = Integer.parseInt(temp[1]);

        writeHeaderLineForListExport(month,year);
        writeDataLinesForListExport(monthAndYear);

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
