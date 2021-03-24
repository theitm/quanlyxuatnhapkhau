package com.haonguyen.StatementService.service;


import com.haonguyen.StatementService.dto.InfoExportAPI;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ExportExcelService implements IExportExcelService{

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private Cell cell;
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
        link.setAddress("'"+nameSheet+"'!A1");
        cell.setHyperlink(link);
        cell.setCellStyle(style);

    }

    //Tạo dòng tiêu đề
    private void writeHeaderLine() {


        sheet = workbook.createSheet("Export");
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(14);
        style.setFont(font);

        createCell(row,0,"Export ID", style);
        createCell(row,1,"Warehouse ID", style);
        createCell(row,2,"Country ID", style);
        createCell(row,3,"Warehouse Name", style);
        createCell(row,4,"Country Name", style);
        createCell(row,5,"Date",style);
        createCell(row,6,"Transportation Coasts", style);
        createCell(row,7,"Sub Total", style);
        createCell(row,8,"List Details Commodity Export", style);
        createCell(row,9,"List Document", style);
    }

    private void writeHeaderLineSheet() {
        sheet = workbook.createSheet("Details Commodity");
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(14);
        style.setFont(font);

        createCell(row,0,"Details Commodity ID", style);
        createCell(row,1,"Details Commodity Name", style);
        createCell(row,2,"Details Description", style);
        createCell(row,3,"Details Price", style);
        createCell(row,4,"Details Unit", style);
        createCell(row,5,"Details Commodity Type",style);
    }


    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        InfoExportAPI[] infoExportAPIS = iStatementService.getInfoExportAPI("12&2021");

       for (InfoExportAPI details : infoExportAPIS) {

            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, details.getExcelExportDTO().getId().toString(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getIdWarehouse(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getIdCountry(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getWarehouseName(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getCountryName(), style);
            createCell(row, columnCount++, details.getExcelExportDTO().getDate(), style);
            createCell(row, columnCount++,"Test Transportation" ,style);
            createCell(row, columnCount++,"Test Total",style);
            //Create Cell And HyperLink
            String nameSheetCommodity = "Commodity " + details.getExcelExportDTO().getId();
            createCellAndHyperLink(row, columnCount++,"Details Commodity" ,style,nameSheetCommodity);
            String nameSheetDocument = "Document " + details.getExcelExportDTO().getId();
            createCellAndHyperLink(row, columnCount++,"Document",style,nameSheetDocument);



        }
    }

    @Override
    public void export(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss_dd-MM-yyyy");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Details_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        writeHeaderLine();
        writeDataLines();
        writeHeaderLineSheet();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }

}
